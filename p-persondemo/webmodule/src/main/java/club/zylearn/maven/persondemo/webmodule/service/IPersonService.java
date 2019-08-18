package club.zylearn.maven.persondemo.webmodule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import club.zylearn.maven.persondemo.webmodule.dao.IPersonDAO;
import club.zylearn.maven.persondemo.webmodule.vo.Person;
import club.zylearn.maven.persondemo.webmodule.vo.Product;

@Service
public class IPersonService {
	@Autowired
	private IPersonDAO personDAO;
	
	@Transactional
	public boolean add(Person vo) {
		boolean flag = false;
		try {
			personDAO.doCreate(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public List<Person> list(){
		List<Person> persons = null;
		try {
			persons = personDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return persons;
	}
}
