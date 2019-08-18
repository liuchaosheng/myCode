package club.zylearn.maven.persondemo.webmodule.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import club.zylearn.maven.persondemo.webmodule.vo.Product;

@Repository
public interface IProductDAO {
	public boolean doCreate(Product vo) throws Exception ;
	public boolean doUpdateCount(Product vo) throws Exception ;
	public List<Product> findAll() throws Exception;
}
