package club.zylearn.maven.persondemo.webmodule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import club.zylearn.maven.persondemo.webmodule.dao.IProductDAO;
import club.zylearn.maven.persondemo.webmodule.vo.Product;

@Service
public class IProductService {
	@Autowired
	private IProductDAO productDAO;
	
	@Transactional
	public boolean add(Product vo) {
		boolean flag = false;
		try {
			productDAO.doCreate(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public List<Product> list(){
		List<Product> products = null;
		try {
			products = productDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
}
