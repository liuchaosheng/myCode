package club.zylearn.maven.mybatisdemo.mybatis_select.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;

import club.zylearn.maven.mybatisdemo.mybatis_select.vo.Person;


public interface IPersonDAO {
	public boolean doCreate(Person vo) throws Exception;
	public boolean doRemove(Integer id) throws Exception ;
	public boolean doUpdate(Person vo) throws Exception ;
	public Person findById(Integer id) throws Exception ;
	public List<Person> findAll() throws Exception ;
	
	// select返回Map<String,Object> key 列名 value 值对象
	public Map<String,Object> findReturnNormalMap(Integer id) throws Exception ;
	
	// select返回Map<primary key,vo> 
	@MapKey("pid")
	public Map<Integer,Person> findAllReturnMap() throws Exception ;
}
