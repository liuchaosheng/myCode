package club.zylearn.maven.persondemo.webmodule.dao;


import org.springframework.stereotype.Repository;

import club.zylearn.maven.persondemo.webmodule.vo.Product;

@Repository
public interface IProductDAO {
	public boolean doCreate(Product vo) throws Exception ;
	public boolean doUpdateCount(Product vo) throws Exception ;
}
