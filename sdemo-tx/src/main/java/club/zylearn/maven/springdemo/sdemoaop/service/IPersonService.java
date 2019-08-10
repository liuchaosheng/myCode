package club.zylearn.maven.springdemo.sdemoaop.service;

import java.util.List;

import club.zylearn.maven.springdemo.sdemoaop.vo.Person;

public interface IPersonService {
	public boolean add(Person vo) throws Exception ;
	public boolean edit(Person vo) throws Exception ;
	public boolean delete(Integer id) throws Exception ;
	public List<Person> list() throws Exception ;
	public Person queryOne(int id) throws Exception ;
}
