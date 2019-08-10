package club.zylearn.maven.mybatisdemo.m_demo1.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import club.zylearn.maven.mybatisdemo.m_demo1.dao.IPersonDAO;
import club.zylearn.maven.mybatisdemo.m_demo1.factory.MySqlSessionFactory;
import club.zylearn.maven.mybatisdemo.m_demo1.vo.Person;

// 通过映射sql使用命名空间的方式实现的dao接口
public class PersonDAOImpl implements IPersonDAO {
	private SqlSession session = null ;
	public PersonDAOImpl() {
		session = MySqlSessionFactory.getSqlSession() ;
	}
	@Override
	public boolean doCreate(Person vo) {
		int count = session.insert("club.zylearn.maven.mybatisdemo.m_demo1.dao.IPersonDAO.doCreate", vo) ;
		return count > 0 ;
	}

	@Override
	public Person findById(Integer id) {
		return session.selectOne("club.zylearn.maven.mybatisdemo.m_demo1.dao.IPersonDAO.findById", id) ;
	}

	@Override
	public boolean doRemove(Integer id) {
		int count = session.delete("club.zylearn.maven.mybatisdemo.m_demo1.dao.IPersonDAO.doRemove", id) ;
		return count > 0 ;
	}

	@Override
	public boolean doUpdate(Person vo) {
		int count = session.update("club.zylearn.maven.mybatisdemo.m_demo1.dao.IPersonDAO.doUpdate",vo) ;
		return count > 0 ;
	}

	@Override
	public List<Person> findAll() {
		List<Person> persons = session.selectList("club.zylearn.maven.mybatisdemo.m_demo1.dao.IPersonDAO.findAll") ;
		return persons ;
	}

}
