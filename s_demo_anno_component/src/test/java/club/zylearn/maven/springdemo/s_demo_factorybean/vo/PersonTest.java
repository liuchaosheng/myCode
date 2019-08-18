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
		Car car = (Car) context.getBean("car");
		System.out.println(person);
		System.out.println(car);
		System.out.println(car.getPerson());
	}

}
