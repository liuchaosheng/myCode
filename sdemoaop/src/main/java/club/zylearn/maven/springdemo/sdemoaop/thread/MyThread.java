package club.zylearn.maven.springdemo.sdemoaop.thread;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import club.zylearn.maven.springdemo.sdemoaop.db.MyThreadConnection;
import club.zylearn.maven.springdemo.sdemoaop.service.IPersonService;
import club.zylearn.maven.springdemo.sdemoaop.vo.Person;

@Scope("prototype")
@Component
public class MyThread implements Runnable {
	@Autowired
	private IPersonService service ;
	
	public IPersonService getPersonServiceImpl() {
		return service;
	}

	public void setPersonServiceImpl(IPersonService service) {
		this.service = service;
	}

	@Override
	public void run() {
		Random ran = new Random() ;
		for(int i = 1 ; i < 10 ; i++) {
//			System.out.println(new MyThreadConnection().getThreadConnection());
			Person vo = new Person() ;
			vo.setAge(ran.nextInt(100));
			vo.setName(Thread.currentThread().getName() + "name" + i );
			vo.setAge(ran.nextInt(50));
			vo.setBirthday(new java.util.Date());
			vo.setSal((double)ran.nextInt(10000));
			try {
				service.add(vo) ;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
