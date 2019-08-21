package club.zylearn.maven.persondemo.webmodule.controller;

import java.io.PrintWriter;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import club.zylearn.maven.persondemo.webmodule.service.IOrdersService;

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
	
	@RequestMapping("/add")
	public String addOrders(@RequestBody OrderRequest to,PrintWriter writer) {
		try {
			String retOrderStr = ordersService.addOrders(to);
			writer.print(retOrderStr);
		} catch (Exception e) {
			// 出现异常打印异常信息
			writer.print(e.getMessage());
		}
		return null;
	}
	@RequestMapping("/list")
	public String addOrders(Map<String,Object> requestMap) {
		try {
			Map<String,Object> ordersMap = ordersService.list();
			requestMap.putAll(ordersMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list-orders";
	}
}
