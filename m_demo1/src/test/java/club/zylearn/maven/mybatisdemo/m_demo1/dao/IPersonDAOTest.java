package club.zylearn.maven.mybatisdemo.m_demo1.dao;

import java.util.List;

import org.junit.Test;

import club.zylearn.maven.mybatisdemo.m_demo1.dao.impl.PersonDAOImpl;
import club.zylearn.maven.mybatisdemo.m_demo1.factory.MySqlSessionFactory;
import club.zylearn.maven.mybatisdemo.m_demo1.vo.Person;

public class IPersonDAOTest {

	@Test
	public void testDoCreate() {
		try {
			//IPersonDAO dao = new PersonDAOImpl() ;
			IPersonDAO dao = MySqlSessionFactory.getSqlSession().getMapper(IPersonDAO.class) ;
			Person vo = new Person() ;
			vo.setName("测试-姓名");
			vo.setAge(30);
			vo.setNote("熬夜做开发的程序员");
			vo.setSal(3000.0);
			dao.doCreate(vo) ;
			MySqlSessionFactory.getSqlSession().commit(); 
		}catch(Exception e){
			MySqlSessionFactory.getSqlSession().rollback(); 
			throw e ;
		}finally {
			MySqlSessionFactory.closeSqlSession(); 
		}
	}

	@Test
	public void testFindById() {
		try {
			//IPersonDAO dao = new PersonDAOImpl() ;
			IPersonDAO dao = MySqlSessionFactory.getSqlSession().getMapper(IPersonDAO.class) ;
			Person p = dao.findById(3) ;
			System.out.println(p);
			
		}catch(Exception e){
			MySqlSessionFactory.getSqlSession().rollback(); 
			throw e ;
		}finally {
			MySqlSessionFactory.closeSqlSession(); 
		}
	}

	@Test
	public void testDoRemove() {
		try {
			//IPersonDAO dao = new PersonDAOImpl() ;
			IPersonDAO dao = MySqlSessionFactory.getSqlSession().getMapper(IPersonDAO.class) ;
			dao.doRemove(3) ;
			MySqlSessionFactory.getSqlSession().commit(); 
		}catch(Exception e){
			MySqlSessionFactory.getSqlSession().rollback(); 
			throw e ;
		}finally {
			MySqlSessionFactory.closeSqlSession(); 
		}
	}

	@Test
	public void testDoUpdate() {
		try {
			//IPersonDAO dao = new PersonDAOImpl() ;
			IPersonDAO dao = MySqlSessionFactory.getSqlSession().getMapper(IPersonDAO.class) ;
			Person vo = new Person() ;
			vo.setPid(4);
			vo.setName("测试-姓名-改变");
			vo.setAge(40);
			vo.setNote("熬夜做开发的程序员-牛逼的change");
			vo.setSal(4000.0);
			dao.doUpdate(vo) ;
			MySqlSessionFactory.getSqlSession().commit(); 
		}catch(Exception e){
			MySqlSessionFactory.getSqlSession().rollback(); 
			throw e ;
		}finally {
			MySqlSessionFactory.closeSqlSession(); 
		}
	}

	@Test
	public void testFindAll() {
		try {
			//IPersonDAO dao = new PersonDAOImpl() ;
			IPersonDAO dao = MySqlSessionFactory.getSqlSession().getMapper(IPersonDAO.class) ;
			List<Person> persons = dao.findAll() ;
			for(Person vo : persons) {
				System.out.println(vo);
			}
			System.out.println("共有记录：" + persons.size());
		}catch(Exception e){
			throw e ;
		}finally {
			MySqlSessionFactory.closeSqlSession(); 
		}
	}

}
