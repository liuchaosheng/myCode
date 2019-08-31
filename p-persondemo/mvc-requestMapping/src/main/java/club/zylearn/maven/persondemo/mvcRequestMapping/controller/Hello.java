package club.zylearn.maven.persondemo.mvcRequestMapping.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/path")
@Controller
public class Hello {
	private static final String SUCCESS = "hello";
	@RequestMapping("/hello")
	public String forMultiRequestMapping() {
		System.out.println("映射路径成功，/requestMapping/hello =====");
		return SUCCESS;
	}
	@RequestMapping(value="/method",method=RequestMethod.GET)
	public String forMethodGet() {
		System.out.println("get请求，映射成功");
		return SUCCESS;
	}
	@RequestMapping(value="/method",method=RequestMethod.POST)
	public String forMethodPost() {
		System.out.println("post请求，映射成功");
		return SUCCESS;
	}
	@RequestMapping(value="/param",params= {"username","age"},headers= {"Accept-Language=zh-CN,zh;q=0.9,en;q=0.8"})
	public String forParam() {
		System.out.println("get请求，映射成功,带有username,age参数");
		return SUCCESS;
	}
	
	@RequestMapping(value="/testAnt/*")
	public String forAntStyle() {
		System.out.println("ant 风格 映射成功");
		return SUCCESS;
	}
	/*
	 * 通过该测试，进一步确认了自己对tomcat在路径映射的优先级的总结正确。
	 * 如果DispatcherServlet使用"/"作为其映射路径的话，虽然其也能映射所有请求，但是.jsp的请求会优先被
	 * tomcat处理并直接映射到jsp页面。
	 * 如果.jsp没有对应资源，则系统返回404错误页面。
	 */
	@RequestMapping(value="/jsp/*")
	public String forTestPathEqualsJsp() {
		System.out.println("ant 风格  跟jsp匹配，映射成功");
		return SUCCESS;
	}
	
	
	@RequestMapping(value="/restful/{id}",method=RequestMethod.GET)
	public String forRestGet(@PathVariable("id")Integer id) {
		System.out.println("restful get 请求 id =" + id);
		return SUCCESS;
	}
	
	@RequestMapping(value="/restful",method=RequestMethod.POST)
	public String forRestPost() {
		System.out.println("restful post 请求 ");
		return SUCCESS;
	}
	@RequestMapping(value="/restful/{id}",method=RequestMethod.PUT)
	public String forRestPut(@PathVariable("id")Integer id,HttpServletRequest request) {
		System.out.println("restful put 请求 id =" + id);
		return "redirect:/"+SUCCESS;
	}
	// TODO  该处没有解决问题，服务器转发到JSP页面的时候JSP页面报错
	@RequestMapping(value="/restful/{id}",method=RequestMethod.DELETE)
	public String forRestDelete(@PathVariable("id")Integer id) {
		System.out.println("restful delete 请求 id =" + id);
		return SUCCESS;
	}
}
