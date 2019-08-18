package club.zylearn.maven.persondemo.webmodule.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import club.zylearn.maven.persondemo.webmodule.service.IPersonService;
import club.zylearn.maven.persondemo.webmodule.vo.Person;

@Controller
@RequestMapping("/person")
public class PersonController {
	@Autowired
	private IPersonService personService;
	@RequestMapping("/add")
	public String addProductHandler(Person vo){
		personService.add(vo);
		return "success" ;
	}
	@RequestMapping("/list")
	public String listProductHandler(Map<String,Object> requestMap){
		List<Person> persons = personService.list();
		for(Person person : persons) {
			person.toString();
		}
		requestMap.put("persons", persons);
		return "list-person" ;
	}
}
