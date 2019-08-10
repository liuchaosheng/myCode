package club.zylearn.maven.persondemo.webmm.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import club.zylearn.maven.persondemo.webmm.factory.MySqlSessionFactory;
import club.zylearn.maven.persondemo.webmm.vo.Person;

public class IPersonDAOTest {
	
	@Test
	public void testDoCreate() {
		ApplicationContext context = new ClassPathXmlApplicationContext("club/zylearn/applicationContext.xml") ;
		SqlSession session = context.getBean("session", SqlSession.class) ;
		MySqlSessionFactory myFatory= context.getBean("mySqlSessionFactory",MySqlSessionFactory.class) ;
		IPersonDAO dao = session.getMapper(IPersonDAO.class) ;
		Person vo = new Person() ;
		vo.setAge(30);
		vo.setName("朝阳");
		vo.setNote("一个牛逼的程序员");
		vo.setSal(9000.0);
		dao.doCreate(vo) ;
		session.commit(); 
		myFatory.closeSqlSession(); 
	}

	@Test
	public void testFindById() {
		ApplicationContext context = new ClassPathXmlApplicationContext("club/zylearn/applicationContext.xml") ;
		SqlSession session = context.getBean("session", SqlSession.class) ;
		MySqlSessionFactory myFatory= context.getBean("mySqlSessionFactory",MySqlSessionFactory.class) ;
		IPersonDAO dao = session.getMapper(IPersonDAO.class) ;
		Person vo = dao.findById(1) ;
		System.out.println(vo);
		myFatory.closeSqlSession(); 
	}

	@Test
	public void testDoRemove() {
		ApplicationContext context = new ClassPathXmlApplicationContext("club/zylearn/applicationContext.xml") ;
		SqlSession session = context.getBean("session", SqlSession.class) ;
		MySqlSessionFactory myFatory= context.getBean("mySqlSessionFactory",MySqlSessionFactory.class) ;
		IPersonDAO dao = session.getMapper(IPersonDAO.class) ;
		dao.doRemove(1) ;
		session.commit(); 
		myFatory.closeSqlSession(); 
	}

	@Test
	public void testDoUpdate() {
		ApplicationContext context = new ClassPathXmlApplicationContext("club/zylearn/applicationContext.xml") ;
		SqlSession session = context.getBean("session", SqlSession.class) ;
		MySqlSessionFactory myFatory= context.getBean("mySqlSessionFactory",MySqlSessionFactory.class) ;
		IPersonDAO dao = session.getMapper(IPersonDAO.class) ;
		Person vo = new Person() ;
		vo.setPid(1);
		vo.setAge(100);
		vo.setName("zhaoyang");
		vo.setNote("一个牛逼的程序员 == 中软国际");
		vo.setSal(100000.0);
		dao.doUpdate(vo) ;
		session.commit(); 
		myFatory.closeSqlSession(); 
	}

	@Test
	public void testFindAll() {
		ApplicationContext context = new ClassPathXmlApplicationContext("club/zylearn/applicationContext.xml") ;
		SqlSession session = context.getBean("session", SqlSession.class) ;
		MySqlSessionFactory myFatory= context.getBean("mySqlSessionFactory",MySqlSessionFactory.class) ;
		IPersonDAO dao = session.getMapper(IPersonDAO.class) ;
		List<Person> persons = dao.findAll() ;
		for(Person vo : persons) {
			System.out.println(vo);
		}
		myFatory.closeSqlSession(); 
	}

}
