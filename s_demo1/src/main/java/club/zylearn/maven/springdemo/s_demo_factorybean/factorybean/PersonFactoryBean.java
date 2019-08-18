package club.zylearn.maven.springdemo.s_demo_factorybean.factorybean;

import java.util.Date;

import org.springframework.beans.factory.FactoryBean;

import club.zylearn.maven.springdemo.s_demo_factorybean.vo.Person;

public class PersonFactoryBean implements FactoryBean<Person> {
	
	// 编写该factoryBean返回对象的方法
	@Override
	public Person getObject() throws Exception {
		Person person = new Person();
		person.setAge(30);
		person.setName("PersonFactoryBean=>张三");
		person.setBirthday(new Date());
		person.setSal(30000.0);
		return person;
	}

	@Override
	public Class<?> getObjectType() {
		return Person.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
	
}
