package test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import club.zylearn.sharding.dao.IPersonDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MyDataSourceTest {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private IPersonDAO dao ;
	@Test
	public void test01() {
//		try {
			System.out.println(dao);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
}
