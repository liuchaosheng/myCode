package club.zylearn.maven.springdemo.s_demo1.vo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonTest {

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml") ;
		Person person1 = context.getBean("person1", Person.class) ;
		Person person2 = context.getBean("person2", Person.class) ;
		Car car1 = context.getBean("car1", Car.class) ;
		System.out.println(person1);
		System.out.println(person2);
		System.out.println(car1);
		System.out.println("\t所属人：" + car1.getPerson());
		
		Car car2 = context.getBean("car2",Car.class);
		System.out.println(car2);
	}

}
