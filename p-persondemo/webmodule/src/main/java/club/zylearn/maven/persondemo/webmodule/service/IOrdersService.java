package club.zylearn.maven.persondemo.webmodule.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import club.zylearn.maven.persondemo.webmodule.controller.OrderRequest;
import club.zylearn.maven.persondemo.webmodule.dao.IOrdersDAO;
import club.zylearn.maven.persondemo.webmodule.dao.IPersonDAO;
import club.zylearn.maven.persondemo.webmodule.dao.IProductDAO;
import club.zylearn.maven.persondemo.webmodule.vo.Orders;
import club.zylearn.maven.persondemo.webmodule.vo.Person;
import club.zylearn.maven.persondemo.webmodule.vo.Product;

@Service
public class IOrdersService {
	@Autowired
	private IPersonDAO personDAO;
	@Autowired
	private IProductDAO productDAO;
	@Autowired
	private IOrdersDAO ordersDAO;
	
	/*
	 * 下订单前调用
	 */
	public Map<String,Object>preAddOrders(Integer pid) throws Exception{
		Map<String,Object> personAndProductsMap = new HashMap<String,Object>();
		Person person = personDAO.findById(pid);
		personAndProductsMap.put("person", person);
		List<Product> products = productDAO.findAll();
		personAndProductsMap.put("products", products);
		return personAndProductsMap;
	}
	/**
	 * 下单请求处理 设置事务控制 设置的回滚异常为Exception
	 */
	@Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRED,isolation=Isolation.REPEATABLE_READ)
	public String addOrders(OrderRequest to) throws Exception{
		// 构造返回字符串
		StringBuilder buf = new StringBuilder();
		
		/*计算订单总价*/
		double allPrice = 0.0;
		// 查询所有关联商品
		Map<Integer,Product> productMap = productDAO.findByIds(to.getProids());
		// 计算订单总价
		List<Integer> counts = to.getCounts();
		List<Integer> proids = to.getProids();
		int size = counts.size();
		for(int i = 0 ; i < size ; i++) {
			double itemPrice = productMap.get(proids.get(i)).getPrice() * counts.get(i);
			allPrice += itemPrice;
			buf.append("产品名称：").append(productMap.get(proids.get(i)).getProname()).append("，").append("购买数量：").append(counts.get(i))
			.append("，").append("价格：").append(itemPrice).append("\n");
		}
		buf.append("==========>总价格：").append(allPrice);
		
		/*增加订单信息*/
		Orders orders = new Orders();
		orders.setAllPrice(allPrice);
		orders.setCreateTime(new Date());
		Person person = personDAO.findById(to.getPid());
		if(person == null) {
			throw new Exception("无对应人员信息");
		}
		orders.setPerson(person);
		ordersDAO.doCreate(orders);
		
		/*增加订单详情信息*/
		for(int i = 0 ; i < size ; i++) {
			int proid = proids.get(i);
			int pcount = counts.get(i);
			// 判断库存是否足够
			Product product = productMap.get(proid);
			if(product.getCount() < pcount) {
				throw new Exception("库存不足");
			}
			// 更新库存信息
			product.setCount(product.getCount() - pcount);
			productDAO.doUpdateCount(product);
			
			int changes = ordersDAO.doCreateOrderDetail(proid, pcount, orders.getOid());
			if(changes <= 0) {
				// 增加失败
				throw new Exception("增加订单详情失败");
			}
		}
		return buf.toString();
	}
	// 根据人员id查询订单信息
	public Map<String,Object> list() throws Exception{
		Map<String,Object> ordersMap = new HashMap<String,Object>();
		List<Orders> allOrders = ordersDAO.findAll();
		ordersMap.put("allOrders", allOrders);
		return ordersMap;
	}
}
