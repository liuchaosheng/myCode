package club.zylearn.maven.persondemo.webmodule.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.zylearn.maven.persondemo.webmodule.dao.IPersonDAO;
import club.zylearn.maven.persondemo.webmodule.dao.IProductDAO;
import club.zylearn.maven.persondemo.webmodule.vo.Person;
import club.zylearn.maven.persondemo.webmodule.vo.Product;

@Service
public class IOrdersService {
	@Autowired
	private IPersonDAO personDAO;
	@Autowired
	private IProductDAO productDAO;
	
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
	
	
}
