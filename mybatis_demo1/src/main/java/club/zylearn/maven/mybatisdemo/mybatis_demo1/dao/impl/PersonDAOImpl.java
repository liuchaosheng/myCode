package club.zylearn.maven.mybatisdemo.mybatis_demo1.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import club.zylearn.maven.mybatisdemo.mybatis_demo1.dao.IPersonDAO;
import club.zylearn.maven.mybatisdemo.mybatis_demo1.factory.MyLocalSqlSessionFactory;
import club.zylearn.maven.mybatisdemo.mybatis_demo1.vo.Person;

public class PersonDAOImpl implements IPersonDAO {
	
	@Override
	public boolean doCreate(Person vo) throws Exception {
		SqlSession session = MyLocalSqlSessionFactory.getLocalSqlSession() ;
		int count = session.insert("club.zylearn.maven.mybatisdemo.mybatis_demo1.dao.IPersonDAO.doCreate", vo) ;
		return count > 0 ;
	}

	@Override
	public boolean doRemove(Integer id) throws Exception {
		SqlSession session = MyLocalSqlSessionFactory.getLocalSqlSession() ;
		int count = session.delete("club.zylearn.maven.mybatisdemo.mybatis_demo1.dao.IPersonDAO.doRemove", id) ;
		return count > 0 ;
	}

	@Override
	public boolean doUpdate(Person vo) throws Exception {
		SqlSession session = MyLocalSqlSessionFactory.getLocalSqlSession() ;
		int count = session.update("club.zylearn.maven.mybatisdemo.mybatis_demo1.dao.IPersonDAO.doUpdate", vo) ;
		return count > 0 ;
	}

	@Override
	public Person findById(Integer id) throws Exception {
		SqlSession session = MyLocalSqlSessionFactory.getLocalSqlSession() ;
		Person person = null ;
		person = (Person)session.selectOne("club.zylearn.maven.mybatisdemo.mybatis_demo1.dao.IPersonDAO.findById",id) ;
		return person ;
	}

	@Override
	public List<Person> findAll() throws Exception {
		SqlSession session = MyLocalSqlSessionFactory.getLocalSqlSession() ;
		List<Person> persons = session.selectList("club.zylearn.maven.mybatisdemo.mybatis_demo1.dao.IPersonDAO.findAll") ;
		return persons ;
	}

}
