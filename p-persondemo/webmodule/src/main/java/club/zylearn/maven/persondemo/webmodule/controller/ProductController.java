package club.zylearn.maven.persondemo.webmodule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import club.zylearn.maven.persondemo.webmodule.dao.IProductDAO;
import club.zylearn.maven.persondemo.webmodule.vo.Product;

@Controller
@RequestMapping("/product")
public class ProductController {
	@RequestMapping("/add")
	public String addProductHandler(Product vo){
		System.out.println(vo);
		return "success" ;
	}
}
