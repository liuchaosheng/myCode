package club.zylearn.maven.mybatisdemo.mybatis_association.maindemo;

import java.util.Date;

import club.zylearn.maven.mybatisdemo.mybatis_association.dao.IOrdersDAO;
import club.zylearn.maven.mybatisdemo.mybatis_association.dao.IProductDAO;
import club.zylearn.maven.mybatisdemo.mybatis_association.factory.MyLocalSqlSessionFactory;
import club.zylearn.maven.mybatisdemo.mybatis_association.vo.Orders;

public class Demo4 {

	public static void main(String[] args) throws Exception {
		IProductDAO productDAO = MyLocalSqlSessionFactory.getLocalSqlSession().getMapper(IProductDAO.class) ;
		IOrdersDAO ordersDAO = MyLocalSqlSessionFactory.getLocalSqlSession().getMapper(IOrdersDAO.class) ;
		try {
			Orders vo = new Orders() ;
			vo.setAllprice(3965.0);
			vo.setCreateTime(new Date());
			ordersDAO.doCreate(vo) ;
			MyLocalSqlSessionFactory.getLocalSqlSession().commit();
		}catch(Exception e){
			MyLocalSqlSessionFactory.getLocalSqlSession().rollback();
			e.printStackTrace();
		}finally {
			MyLocalSqlSessionFactory.closeLocalSqlSession(); 
		}
	}
}

/*oracle
set pagesize 30;
set linesize 300;
col ename for a15;
col note for a20;
*/
