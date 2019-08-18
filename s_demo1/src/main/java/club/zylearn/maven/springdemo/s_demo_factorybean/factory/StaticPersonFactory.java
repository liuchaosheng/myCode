package club.zylearn.maven.springdemo.s_demo_factorybean.factory;

import java.util.Date;

import club.zylearn.maven.springdemo.s_demo_factorybean.vo.Person;

public class StaticPersonFactory {
	public static Person getPerson() {
		Person person = new Person();
		person.setAge(30);
		person.setName("StaticPersonFactory=>张三");
		person.setBirthday(new Date());
		person.setSal(30000.0);
		return person;
	}
}
