package club.zylearn.maven.mybatisdemo.mybatis_association.maindemo;

import club.zylearn.maven.mybatisdemo.mybatis_association.dao.IPersonDAO;
import club.zylearn.maven.mybatisdemo.mybatis_association.factory.MyLocalSqlSessionFactory;
import club.zylearn.maven.mybatisdemo.mybatis_association.vo.Person;

public class Demo1 {

	public static void main(String[] args) throws Exception {
		IPersonDAO personDAO = MyLocalSqlSessionFactory.getLocalSqlSession().getMapper(IPersonDAO.class) ;
		try {
			Person vo = personDAO.findByIdUseResultMap(10) ;
			System.out.println("=======================================");
			System.out.println(vo);
			System.out.println("=======================================");
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
