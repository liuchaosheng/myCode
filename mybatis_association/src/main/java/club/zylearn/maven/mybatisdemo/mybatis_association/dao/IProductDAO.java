package club.zylearn.maven.mybatisdemo.mybatis_association.dao;

import club.zylearn.maven.mybatisdemo.mybatis_association.vo.Product;

public interface IProductDAO {
	public boolean doCreate(Product vo) throws Exception ;
	public boolean doUpdateCount(Product vo) throws Exception ;
}
