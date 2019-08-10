package club.zylearn.maven.springdemo.sdemoaop.aspect;

import java.sql.SQLException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import club.zylearn.maven.springdemo.sdemoaop.db.MyThreadConnection;

// 注册一个切面类名称为DemoAspect
@Aspect
@Component
public class TransactionAspect {
	@Autowired
	private MyThreadConnection mtc ;
	// 该切面的前置通知
	@Before("execution(public * club.zylearn.maven.springdemo.sdemoaop.service.impl.PersonServiceImpl.*(..))")
	public void beforeFunc(JoinPoint joinPoint) {
		try {
			mtc.getThreadConnection().setAutoCommit(false);
			System.out.println("打开数据连接并事务开启+++++++++++++++++++++++");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 该切面的后置通知
	@After("execution(public * club.zylearn.maven.springdemo.sdemoaop.service.impl.PersonServiceImpl.*(..))")
	public void afterFunc(JoinPoint joinPoint) {
//		mtc.closeThreadConnection(); 
		System.out.println("后置通知+++++++++++++++++++++++");
	}
	
	// 该切面的后置返回通知
	@AfterReturning(value="execution(public * club.zylearn.maven.springdemo.sdemoaop.service.impl.PersonServiceImpl.*(..))",
			returning="result")
	public void afterReturningFunc(JoinPoint joinPoint,Object result) {
		System.out.println("返回判断是否更新成功 +++++++++++++++++++++++");
		if(result instanceof Boolean) {
			Boolean b = (Boolean)result ;
			if(b) {
				try {
					mtc.getThreadConnection().commit();
					System.out.println("事务提交 +++++++++++++++++++++++");
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}else {
				try {
					mtc.getThreadConnection().rollback();
					System.out.println("事务回滚 +++++++++++++++++++++++");
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
		}
		mtc.closeThreadConnection(); 
		System.out.println("关闭数据库 +++++++++++++++++++++++");
	}
	// 该切面的后置异常通知
	@AfterThrowing(value="execution(public * club.zylearn.maven.springdemo.sdemoaop.service.impl.PersonServiceImpl.*(..))",throwing="ex")
	public void afterThrowingFunc(JoinPoint joinPoint,Exception ex) {
		System.out.println("产生异常 +++++++++++++++++++++++");
		System.out.println(ex);
		try {
			mtc.getThreadConnection().rollback();
			System.out.println("事务回滚 +++++++++++++++++++++++");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			mtc.closeThreadConnection(); 
			System.out.println("关闭数据库 +++++++++++++++++++++++");
		}
	}
}
