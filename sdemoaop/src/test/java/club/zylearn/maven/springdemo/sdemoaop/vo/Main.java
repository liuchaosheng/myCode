package club.zylearn.maven.springdemo.sdemoaop.vo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import club.zylearn.maven.springdemo.sdemoaop.service.IPersonService;

public class Main {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml") ;
		IPersonService service = context.getBean("personServiceImpl",IPersonService.class) ;
//		System.out.println(service.getClass().getName());
//		new Thread(context.getBean("myThread",Runnable.class),"线程5").start(); 
//		new Thread(context.getBean("myThread",Runnable.class),"线程6").start(); 
//		new Thread(context.getBean("myThread",Runnable.class),"线程7").start(); 
//		new Thread(context.getBean("myThread",Runnable.class),"线程8").start(); 
//		new Thread(context.getBean("myThread",Runnable.class),"线程9").start(); 
//		new Thread(context.getBean("myThread",Runnable.class),"线程10").start(); 
		
//		Person vo = new Person() ;
//		vo.setName("修改-many");
//		vo.setAge(27) ;
//		vo.setBirthday(new java.util.Date());
//		vo.setPid(30);
//		vo.setSal(4000.0);
//		try {
//			service.edit(vo) ;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
//		try {
//			service.delete(40) ;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		Person vo = service.queryOne(50) ;
//		System.out.println(vo) ;
		
//		System.getProperties().list(System.out);
		MyProp prop = (MyProp) context.getBean("proper");
		System.out.println(prop);
	}
	
	

}
