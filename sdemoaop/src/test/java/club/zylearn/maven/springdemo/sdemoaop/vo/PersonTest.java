package club.zylearn.maven.springdemo.sdemoaop.vo;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import club.zylearn.maven.springdemo.sdemoaop.datasource.MyDataSource;
import club.zylearn.maven.springdemo.sdemoaop.db.MyThreadConnection;
import club.zylearn.maven.springdemo.sdemoaop.service.IPersonService;
import club.zylearn.maven.springdemo.sdemoaop.thread.MyThread;

public class PersonTest {

	@Test
	public void test() throws Exception {
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml") ;
//		Person p = new Person() ;
//		p.setName("朝阳");
//		IPersonService service = context.getBean("personServiceImpl", IPersonService.class) ;
//		service.add(p) ;
//		DemoAspect demo = context.getBean(DemoAspect.class) ;
//		System.out.println(demo);
//		Person person = context.getBean("person",Person.class) ;
//		System.out.println(person);
		
		// 加载数据库驱动程序
		Class.forName("com.mysql.jdbc.Driver") ;
		
		// 取得连接对象
		DataSource ds = new MyDataSource() ;
		Connection conn = ds.getConnection() ;
		System.out.println(conn);
		
	}
	
	@Test
	public void test01() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml") ;
		IPersonService service = context.getBean("personServiceImpl",IPersonService.class) ;
		System.out.println(service.getClass().getName());
		Person vo = new Person() ;
		vo.setAge(30);
		vo.setName("小力");
		vo.setSal(9000.0);
		vo.setBirthday(new java.util.Date());
		service.add(vo) ;
//		MyThreadConnection mtc = context.getBean("myThreadConnection",MyThreadConnection.class) ;
//		System.out.println(mtc);
	}
	@Test
	public void test02() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml") ;
//		IPersonService service = context.getBean("personServiceImpl",IPersonService.class) ;
//		System.out.println(service.getClass().getName());
		new Thread(context.getBean("myThread",Runnable.class),"线程1").start(); 
//		new Thread(context.getBean("myThread",Runnable.class),"线程2").start();  
//		new Thread(context.getBean("myThread",Runnable.class),"线程3").start(); 
//		new Thread(context.getBean("myThread",Runnable.class),"线程4").start(); 
//		System.out.println(context.getBean("myThread",MyThread.class).getPersonServiceImpl().getClass().getName()) ;
//		System.out.println(context.getBean("myThread",Runnable.class));
//		System.out.println(context.getBean("myThread",Runnable.class));
	}

}
