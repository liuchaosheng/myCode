package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import club.zylearn.sharding.service.PersonService;
import club.zylearn.sharding.vo.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ServiceAddTest {
	@Autowired
	private PersonService personService;
	@Test
	public void test01() {
		Person person = new Person();
		person.setAge(30);
		person.setNote("一个牛逼的程序员");
		person.setPname("刘朝胜");
		personService.add(person);
	}
	
	@Test
	public void test02() {
		System.out.println(personService.getOne(1567874659039L));
	}
	
	@Test
	public void test03() {
		Person person = new Person();
		person.setId(1567872419835L);
		person.setPname("张三");
		person.setAge(31);
		person.setNote("挂羊头卖狗肉的沙子");
		personService.edit(person);
	}
}
