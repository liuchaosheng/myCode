package club.zylearn.maven.persondemo.webmodule.dao;


import java.util.List;

import club.zylearn.maven.persondemo.webmodule.vo.OrderDetail;
import club.zylearn.maven.persondemo.webmodule.vo.Orders;

public interface IOrdersDAO {
	public boolean doCreate(Orders vo) throws Exception ;
	public boolean doUpdatePrice(Orders vo) throws Exception ;
	public Orders findByIdDeep(Integer id) throws Exception ;
	public List<OrderDetail> findOrderDetailsById(Integer id) throws Exception ;
}
