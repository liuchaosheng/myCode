package club.zylearn.maindemo;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import club.zylearn.maven.springdemo.sdemoaop.service.IPersonService;
import club.zylearn.maven.springdemo.sdemoaop.vo.Person;

public class DemoTx {

	public static void main(String[] args){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml") ;
		IPersonService personService = ac.getBean("personServiceImpl", IPersonService.class) ;
		System.out.println(personService.getClass().getName()) ;
		Person vo = new Person() ;
		vo.setPid(224);
		vo.setAge(300);
		vo.setName("liu-chaosheng");
		vo.setBirthday(new Date());
		vo.setSal(333333.3);
		try {
			personService.edit(vo) ;
		} catch (Exception e) {
//			e.printStackTrace();
		}
		System.out.println("---------------------");
	}

}
