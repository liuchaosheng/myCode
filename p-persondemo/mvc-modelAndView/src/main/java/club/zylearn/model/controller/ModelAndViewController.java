package club.zylearn.model.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import club.zylearn.model.vo.Person;

@Controller
@SessionAttributes(value= {"msg"})
public class ModelAndViewController {
	//测试该控制器方法返回ModelAndView
	//这里的测试将构造一起集合，然后将该集合在页面中展示
	@RequestMapping("/list")
	public ModelAndView forGetAllPerson() {
		ModelAndView mv = new ModelAndView();
		//设置视图名称
		mv.setViewName("hello");
		//模拟对象获取的方法
		List<Person> persons = new ArrayList<>();
		Person person1 = new Person();
		person1.setAge(30);
		person1.setName("zhaoyang");
		person1.setPid(100001);
		
		Person person2 = new Person();
		person2.setAge(30);
		person2.setName("小明");
		person2.setPid(100002);
		
		Person person3 = new Person();
		person3.setAge(30);
		person3.setName("john");
		person3.setPid(100003);
		
		persons.add(person1);
		persons.add(person2);
		persons.add(person3);
		
		//向模型中加入数据
		mv.addObject("persons", persons);
		
		return mv;
	}
	// 同时目标方法的入参也可以放入Map，当入参是Map的时候，那么框架
	// 会自动生成ExtendedModelMap对象传入
	// HashMap <== LinkedHashMap <== ModelMap <== ExtendedModelMap <== BindingAwareModelMap
	// 获取入参传入Model类型 Model接口也被 ExtendedModelMap实现了。
	
	// 测试使用Map作为入参
	@RequestMapping("/list1")
	public String forGetAllPersonMap(Map<String,Object> map) {
		List<Person> persons = new ArrayList<>();
		Person person1 = new Person();
		person1.setAge(30);
		person1.setName("zhaoyang");
		person1.setPid(100001);
		
		Person person2 = new Person();
		person2.setAge(30);
		person2.setName("小明");
		person2.setPid(100002);
		
		Person person3 = new Person();
		person3.setAge(30);
		person3.setName("john");
		person3.setPid(100003);
		
		persons.add(person1);
		persons.add(person2);
		persons.add(person3);
		
		//向模型中加入数据
		map.put("persons", persons);
		
		return "hello";
	}
	
	//测试使用Model作为入参
	@RequestMapping("/list2")
	public String forGetAllPersonModel(Model model) {
		List<Person> persons = new ArrayList<>();
		Person person1 = new Person();
		person1.setAge(30);
		person1.setName("zhaoyang");
		person1.setPid(100001);
		
		Person person2 = new Person();
		person2.setAge(30);
		person2.setName("小明");
		person2.setPid(100002);
		
		Person person3 = new Person();
		person3.setAge(30);
		person3.setName("john");
		person3.setPid(100003);
		
		persons.add(person1);
		persons.add(person2);
		persons.add(person3);
		
		//向模型中加入数据
		model.addAttribute("persons", persons);
		return "hello";
	}
	
	//测试SessionAttribute的使用  该注解比如使用在类上不能使用在方法上
	//value是字符串数组指定会将模型中的那个key设置到session中
	@RequestMapping("/session")
	public String forSessionDemo(Model model) {
		model.addAttribute("msg", "今天很凉快，自己一个人在家里写代码！！！");
		System.out.println("设置session成功！");
		return "hello";
	}
}
