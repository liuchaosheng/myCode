package club.zylearn.maven.mybatisdemo.m_demo1.factory;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MySqlSessionFactoryTest {

	@Test
	public void testGetSqlSession() {
		SqlSession session = MySqlSessionFactory.getSqlSession() ;
		System.out.println(session);
		MySqlSessionFactory.closeSqlSession();
	}

	@Test
	public void testCloseSqlSession() {
		
	}

}
