package club.zylearn.maven.mybatisdemo.mybatis_resultmap.maindemo;

import java.util.List;

import club.zylearn.maven.mybatisdemo.mybatis_resultmap.dao.IDeptDAO;
import club.zylearn.maven.mybatisdemo.mybatis_resultmap.factory.MyLocalSqlSessionFactory;
import club.zylearn.maven.mybatisdemo.mybatis_resultmap.vo.Dept;

public class Demo3 {

	public static void main(String[] args) throws Exception {
		IDeptDAO deptDAO = MyLocalSqlSessionFactory.getLocalSqlSession().getMapper(IDeptDAO.class) ;
		try {
			Dept dept = deptDAO.findByIdDeep(1);
			System.out.println(dept);
			System.out.println(dept.getEmps());
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
