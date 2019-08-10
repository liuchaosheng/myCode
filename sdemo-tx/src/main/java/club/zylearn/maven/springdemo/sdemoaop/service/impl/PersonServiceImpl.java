package club.zylearn.maven.springdemo.sdemoaop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.zylearn.maven.springdemo.sdemoaop.dao.IPersonDAO;
import club.zylearn.maven.springdemo.sdemoaop.service.IPersonService;
import club.zylearn.maven.springdemo.sdemoaop.vo.Person;

@Service
public class PersonServiceImpl implements IPersonService {
	@Autowired
	private IPersonDAO dao ;
	
	@Override
	public boolean add(Person vo) throws Exception {
		return dao.doCreate(vo) ;
	}

	@Override
	public boolean edit(Person vo) throws Exception {
		return dao.doUpdate(vo) ;
	}

	@Override
	public boolean delete(Integer id) throws Exception {
		return dao.doRemove(id) ;
	}

	@Override
	public List<Person> list() throws Exception {
		return dao.findAll() ;
	}

	@Override
	public Person queryOne(int id) throws Exception {
		return dao.findById(id) ;
	}
	
}
