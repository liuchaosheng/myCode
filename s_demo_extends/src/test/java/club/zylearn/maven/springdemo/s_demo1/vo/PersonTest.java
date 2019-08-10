package club.zylearn.maven.springdemo.s_demo1.vo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonTest {

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml") ;
		Car car2 = context.getBean("car2", Car.class) ;
		Car car3 = context.getBean("car3", Car.class) ;
		System.out.println(car2);
		System.out.println(car3);
		System.out.println(car2 == car3);
		
	}

}
