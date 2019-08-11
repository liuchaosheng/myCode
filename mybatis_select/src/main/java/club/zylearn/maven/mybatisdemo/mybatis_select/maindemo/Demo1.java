package club.zylearn.maven.mybatisdemo.mybatis_select.maindemo;

import java.util.Map;

import club.zylearn.maven.mybatisdemo.mybatis_select.dao.IPersonDAO;
import club.zylearn.maven.mybatisdemo.mybatis_select.factory.MyLocalSqlSessionFactory;

public class Demo1 {

	public static void main(String[] args) throws Exception {
		IPersonDAO personDAO = MyLocalSqlSessionFactory.getLocalSqlSession().getMapper(IPersonDAO.class) ;
		try {
			Map<String,Object> map = personDAO.findReturnNormalMap(221) ;
			System.out.println("=======================================");
			for(Map.Entry<String,Object> entry : map.entrySet()) {
				System.out.println("key=" + entry.getKey() + "，value=" + entry.getValue() + "，valueType=" + entry.getValue().getClass().getName());
			}
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
