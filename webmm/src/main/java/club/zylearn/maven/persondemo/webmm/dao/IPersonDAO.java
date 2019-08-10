package club.zylearn.maven.persondemo.webmm.dao;


import java.util.List;

import club.zylearn.maven.persondemo.webmm.vo.Person;

public interface IPersonDAO {
	public boolean doCreate(Person vo) ;
	public Person findById(Integer id) ;
	public boolean doRemove(Integer id) ;
	public boolean doUpdate(Person vo) ;
	public List<Person> findAll() ;
}
