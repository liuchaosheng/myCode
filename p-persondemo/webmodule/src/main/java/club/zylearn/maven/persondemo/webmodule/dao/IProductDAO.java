package club.zylearn.maven.persondemo.webmodule.dao;


import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.MapKey;
import org.springframework.stereotype.Repository;

import club.zylearn.maven.persondemo.webmodule.vo.Product;

@Repository
public interface IProductDAO {
	public boolean doCreate(Product vo) throws Exception ;
	public boolean doUpdateCount(Product vo) throws Exception ;
	public List<Product> findAll() throws Exception;
	// 根据传入产品id的set集合查询包含的产品信息使用Map返回
	@MapKey("proid")
	public Map<Integer,Product> findByIds(List<Integer> ids) throws Exception;
}
