package club.zylearn.maven.persondemo.webmodule.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import club.zylearn.maven.persondemo.webmodule.service.IOrdersService;
import club.zylearn.maven.persondemo.webmodule.service.IPersonService;
import club.zylearn.maven.persondemo.webmodule.service.IProductService;

@Controller
@RequestMapping("/orders")
public class OrdersController {
	@Autowired
	private IOrdersService ordersService;
	@RequestMapping("/preadd")
	public String preAddOrders(@RequestParam("pid")Integer pid,Map<String,Object> requestMap) {
		try {
			Map<String,Object> personAndProductsMap = ordersService.preAddOrders(pid);
			requestMap.putAll(personAndProductsMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "pre-orders";
	}
}
