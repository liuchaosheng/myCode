package club.zylearn.maven.persondemo.webmodule.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import club.zylearn.maven.persondemo.webmodule.vo.OrderDetail;
import club.zylearn.maven.persondemo.webmodule.vo.Orders;

public interface IOrdersDAO {
	public List<Orders> findAll() throws Exception;
	public boolean doCreate(Orders vo) throws Exception ;
	public boolean doUpdatePrice(Orders vo) throws Exception ;
	public List<OrderDetail> findOrderDetailsById(Integer id) throws Exception ;
	public Integer doCreateOrderDetail(@Param("proid")Integer proid,@Param("pcount")Integer pcount,@Param("oid")Integer oid) throws Exception;
}
