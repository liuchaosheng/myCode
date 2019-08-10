package club.zylearn.maven.mybatisdemo.mybatis_datasource.dao;

import java.util.List;

import club.zylearn.maven.mybatisdemo.mybatis_datasource.vo.Person;


public interface IPersonDAO {
	public boolean doCreate(Person vo) throws Exception;
	public boolean doRemove(Integer id) throws Exception ;
	public boolean doUpdate(Person vo) throws Exception ;
	public Person findById(Integer id) throws Exception ;
	public List<Person> findAll() throws Exception ;
}
