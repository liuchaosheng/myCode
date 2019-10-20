package club.zylearn.maven.persondemo.webmodule.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import club.zylearn.maven.persondemo.webmodule.service.IPersonService;
import club.zylearn.maven.persondemo.webmodule.vo.Person;

@Controller
@RequestMapping("/person")
public class PersonController {
	@Autowired
	private IPersonService personService;
	@RequestMapping("/add")
	public String addProductHandler(Person vo){
		personService.add(vo);
		return "success" ;
	}
	@RequestMapping("/list")
	public String listProductHandler(Map<String,Object> requestMap){
		List<Person> persons = personService.list();
		for(Person person : persons) {
			person.toString();
		}
		requestMap.put("persons", persons);
		return "list-person" ;
	}
	
	// 定义使用ajax进行数据访问 只是测试
	@RequestMapping("/addUserJson")
	@ResponseBody
	BaseResponse addPersonUserJson(@RequestBody TestRequest testRequest,@RequestHeader(value="x-nodeid",required=false) int nodeId) {
		System.out.println(testRequest);
		System.out.println(nodeId);
		BaseResponse response = new BaseResponse();
		response.setMsg("json成功访问");
		response.setRetCode(100001);
		return response;
	}
	
	// 定义使用ajax进行数据访问 复杂对象
		@RequestMapping("/addUserJsonNew")
		@ResponseBody
		BaseResponse addPersonUserJsonMulty(@RequestBody TestRequestMulty testRequest) {
			System.out.println(testRequest);
			BaseResponse response = new BaseResponse();
			response.setMsg("json成功访问");
			response.setRetCode(100001);
			return response;
		}
}
