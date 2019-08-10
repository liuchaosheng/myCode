package club.zylearn.maven.springdemo.sdemoaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// 注册一个切面类名称为DemoAspect
//@Aspect
//@Component
public class DemoAspect {
//	// 该切面的前置通过
//	@Before("execution(public void club.zylearn.maven.springdemo.sdemoaop.service.impl.PersonServiceImpl.*(..))")
//	public void beforeFunc(JoinPoint joinPoint) {
//		System.out.println("demo切面的前置通知执行 ++++");
//	}
//	
//	// 该切面的后置通过
//	@After("execution(public void club.zylearn.maven.springdemo.sdemoaop.service.impl.PersonServiceImpl.*(..))")
//	public void afterFunc(JoinPoint joinPoint) {
//		System.out.println("demo切面的后置通知执行 ++++");
//	}
//	
//	// 该切面的后置返回通过
//	@AfterReturning("execution(public void club.zylearn.maven.springdemo.sdemoaop.service.impl.PersonServiceImpl.*(..))")
//	public void afterReturningFunc(JoinPoint joinPoint) {
//		System.out.println("demo切面的后置返回通知执行 ++++");
//	}
//	
//	@AfterThrowing("execution(public void club.zylearn.maven.springdemo.sdemoaop.service.impl.PersonServiceImpl.*(..))")
//	public void afterThrowingFunc(JoinPoint joinPoint) {
//		System.out.println("demo切面的后置异常通知执行 ++++");
//	}
}
