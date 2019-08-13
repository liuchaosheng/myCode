package club.zylearn.maven.mybatisdemo.mybatis_association.maindemo;

import club.zylearn.maven.mybatisdemo.mybatis_association.dao.IProductDAO;
import club.zylearn.maven.mybatisdemo.mybatis_association.factory.MyLocalSqlSessionFactory;
import club.zylearn.maven.mybatisdemo.mybatis_association.vo.Product;

public class Demo2 {

	public static void main(String[] args) throws Exception {
		IProductDAO productDAO = MyLocalSqlSessionFactory.getLocalSqlSession().getMapper(IProductDAO.class) ;
		try {
			Product product = new Product() ;
			product.setProname("菜刀") ;
			product.setCount(100);
			product.setPrice(30.0);
			product.setOriprice(20.0);
			productDAO.doCreate(product) ;
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
