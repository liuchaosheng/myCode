package club.zylearn.maven.mybatisdemo.mybatis_association.dao;

import java.util.List;

import club.zylearn.maven.mybatisdemo.mybatis_association.vo.OrderDetail;
import club.zylearn.maven.mybatisdemo.mybatis_association.vo.Orders;

public interface IOrdersDAO {
	public boolean doCreate(Orders vo) throws Exception ;
	public boolean doUpdatePrice(Orders vo) throws Exception ;
	public Orders findByIdDeep(Integer id) throws Exception ;
	public List<OrderDetail> findOrderDetailsById(Integer id) throws Exception ;
}
