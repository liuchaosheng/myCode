package webmodule.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import club.zylearn.maven.persondemo.webmodule.dao.IProductDAO;
import club.zylearn.maven.persondemo.webmodule.vo.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
@Transactional
public class InitTest {
	@Autowired
	private IProductDAO productDAO;
	@Autowired
	private SqlSessionFactory factory;
	@Test
	public void test() throws Exception {
//		System.out.println(factory);
//		SqlSession session = factory.openSession();
//		IProductDAO dao = session.getMapper(IProductDAO.class);
////		System.out.println(dao.getClass().getName());
//		Product vo = new Product();
//		vo.setProname("OPPO 手机");
//		vo.setCount(30);
//		vo.setOriprice(2000.0);
//		vo.setPrice(3500.0);
//		dao.doCreate(vo);
//		System.out.println(this.getClass().getName());
//		SqlSession s1 = factory.openSession();
//		SqlSession s2 = factory.openSession();
//		System.out.println((s1.getConnection() == s2.getConnection())  + "================================================");
		System.out.println(productDAO + "================================================");
	}

}
