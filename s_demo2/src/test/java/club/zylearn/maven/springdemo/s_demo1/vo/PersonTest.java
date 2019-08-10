package club.zylearn.maven.springdemo.s_demo1.vo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonTest {

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml") ;
		Book book = context.getBean("book1",Book.class) ;
		Company com1 = context.getBean("com1", Company.class) ;
		System.out.println(com1);
		System.out.println("\t员工：");
		for(Person p : com1.getPersons()) {
			System.out.println("\t" + p);
		}
		System.out.println(book);
	}

}
