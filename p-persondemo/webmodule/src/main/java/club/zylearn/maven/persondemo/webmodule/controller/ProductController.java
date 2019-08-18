package club.zylearn.maven.persondemo.webmodule.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import club.zylearn.maven.persondemo.webmodule.service.IProductService;
import club.zylearn.maven.persondemo.webmodule.vo.Product;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private IProductService productService;
	@RequestMapping("/add")
	public String addProductHandler(Product vo){
		productService.add(vo);
		return "success" ;
	}
	@RequestMapping("/list")
	public String listProductHandler(Map<String,Object> requestMap){
		List<Product> products = productService.list();
		requestMap.put("products", products);
		return "list-product" ;
	}
}
