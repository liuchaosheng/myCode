package club.zylearn.maven.mybatisdemo.mybatis_resultmap.maindemo;

import java.util.List;

import club.zylearn.maven.mybatisdemo.mybatis_resultmap.dao.IDeptDAO;
import club.zylearn.maven.mybatisdemo.mybatis_resultmap.factory.MyLocalSqlSessionFactory;
import club.zylearn.maven.mybatisdemo.mybatis_resultmap.vo.Dept;

public class Demo4 {

	public static void main(String[] args) throws Exception {
		IDeptDAO deptDAO = MyLocalSqlSessionFactory.getLocalSqlSession().getMapper(IDeptDAO.class) ;
		try {
			List<Dept> depts = deptDAO.findAll();
			for(Dept d : depts) {
				System.out.println(d);
				System.out.println(d.getEmps());
				System.out.println("=================");
			}
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
