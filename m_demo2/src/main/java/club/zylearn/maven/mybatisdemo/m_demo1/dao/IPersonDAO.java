package club.zylearn.maven.mybatisdemo.m_demo1.dao;


import java.util.List;

import club.zylearn.maven.mybatisdemo.m_demo1.vo.Person;

public interface IPersonDAO {
	public boolean doCreate(Person vo) ;
	public Person findById(Integer id) ;
	public boolean doRemove(Integer id) ;
	public boolean doUpdate(Person vo) ;
	public List<Person> findAll() ;
}
