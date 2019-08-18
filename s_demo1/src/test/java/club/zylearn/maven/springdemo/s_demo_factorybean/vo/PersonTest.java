package club.zylearn.maven.springdemo.s_demo_factorybean.vo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import club.zylearn.maven.springdemo.s_demo_factorybean.vo.Car;
import club.zylearn.maven.springdemo.s_demo_factorybean.vo.Person;

public class PersonTest {

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml") ;
		Person person = (Person) context.getBean("person");
		Person person1 = (Person) context.getBean("person1");
		Person person2 = (Person) context.getBean("person2");
		System.out.println(person);
		System.out.println(person1);
		System.out.println(person2);
	}

}
