package club.zylearn.modelnn.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import club.zylearn.modelnn.vo.Person;

@Controller
public class ModelnnController {
	private static final String HELLO = "hello";
	// 使用ModelAttribute修饰方法
	@ModelAttribute
	public void forPreEdit(Map<String,Object> modelMap) {
		Person person = new Person();
		person.setAge(30);
		modelMap.put("person", person);
	}
	
	@RequestMapping("/personedit")
	public String forPersonEdit(Person mm,Map<String,Object> modelMap) {
		System.out.println(mm  + "==========");
		return HELLO;
	}
	
	/**
	 * 18.测试@ModelAttribute注解:
	 * 1.运行流程:
	 * ① ModelAttribute注解修饰的方法从数据库中获取到对象的相关数据,把数据放入到Map中,键为:userBean.
	 * ② SpringMVC从Map中取出UserBean对象,并把表单参数赋给该UserBean对象对应的属性
	 * ③ SpringMVC把上述对象传给目标方法的入参
	 * 注意:@ModelAttribute修饰的方法中,放入到Map中的键和目标方法入参类型的第一个字母小写的字符串
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
}
