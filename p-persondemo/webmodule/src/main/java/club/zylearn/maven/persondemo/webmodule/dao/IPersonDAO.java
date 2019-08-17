package club.zylearn.maven.persondemo.webmodule.dao;


import java.util.List;

import club.zylearn.maven.persondemo.webmodule.vo.Person;


public interface IPersonDAO {
	public boolean doCreate(Person vo) throws Exception;
	public boolean doRemove(Integer id) throws Exception ;
	public boolean doUpdate(Person vo) throws Exception ;
	public Person findById(Integer id) throws Exception ;
	public List<Person> findAll() throws Exception ;
		
	// 使用resultMap返回查询结果
	public Person findByIdUseResultMap(Integer id) throws Exception ;
}
