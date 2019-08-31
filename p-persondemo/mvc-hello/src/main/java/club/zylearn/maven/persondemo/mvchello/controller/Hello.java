package club.zylearn.maven.persondemo.mvchello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {
	/*
	 * 1、mvc开发首先要引入jar包 
	 * 		（1）使用maven的话
	 * 		<dependency>
	  			<groupId>org.springframework</groupId>
	  			<artifactId>spring-webmvc</artifactId>
	  		</dependency>
	  		（2）或者直接加入：core/beans/context/expression/aop/web
	 * 2、然后想让mvn框架跟web应用关联，需要在web中配置DispatcherServlet并配置：
	 * 		<init-param>
				<!-- 配置servlet的初始化参数，该参数将是其创建bean容器的路径 -->
				<param-name>contextConfigLocation</param-name>
				<param-value>classpath:applicationContext.xml</param-value>
			</init-param>
			并将映射路径设置为/或者/*(区别已经在本项目的web.xml文件注释中说明了)
		3、在applicationContext.xml文件中配置bean容器扫描的包。
			并配置视图解析器。
		4、写控制器来，并在方法上表明@RequestMapping注解，value=""表示映射的路径
			本例中的控制器方法返回String类型会直接被框架解析成一个jsp页面。
	 */
	@RequestMapping("/hello")
	public String forHello() {
		System.out.println("映射成功，helloWorld!!!");
		return "hello";
	}
}
