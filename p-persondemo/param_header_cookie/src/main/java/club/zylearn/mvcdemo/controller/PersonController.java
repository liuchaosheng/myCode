package club.zylearn.mvcdemo.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import club.zylearn.mvcdemo.vo.Person;

@Controller
public class PersonController {
	private static final String HELLO = "hello";
	// 测试RequestParam来获取参数的场景
	@RequestMapping("/path/addperson")
	public String forAddPerson(@RequestParam("name")String name,@RequestParam(value="age",required=false,defaultValue="30")int age) {
		System.out.println("name = " + name + ",age = " + age);
		return HELLO;
	}
	// 测试通过RequestHeader来获取请求头的场景
	@RequestMapping("/path/referdemo")
	public String forReferDemo(@RequestHeader(value="Referer",required=false)String referer) {
		System.out.println("进入网页：" + referer);
		return HELLO;
	}
	// 测试通过CookieValue来进行Cookie值获取的场景
	@RequestMapping("/path/cookie")
	public String forCookieValue(@CookieValue("JSESSIONID") String sessionId) {
		System.out.println("sessionId：" + sessionId);
		return HELLO;
	}
	
	// 测试将vo对象设置成控制器方法参数的场景
	@RequestMapping("/path/paramvo")
	public String forParamvo(Person vo) {
		System.out.println(vo);
		return HELLO;
	}
	
	// 测试使用Servlet原生的api
	@RequestMapping("/path/servletapi")
	public void forServletapi(HttpServletRequest request,HttpServletResponse response,HttpSession session,Writer writer,Person vo) {
		// 在Session中放入一个Person对象
		session.setAttribute("person", vo);
		// 使用writer返回request对象中的头信息
		Enumeration<String> enu = request.getHeaderNames();
		while(enu.hasMoreElements()) {
			String headName = enu.nextElement();
			String headValue = request.getHeader(headName);
			try {
				writer.write(headName + " = " + headValue + "\n");
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}
	// 测试从session中取数据
	@RequestMapping("/path/getsession")
	public void forGetsession(HttpSession session,Writer writer) {
		Person vo = (Person) session.getAttribute("person");
		try {
			writer.write(vo.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
