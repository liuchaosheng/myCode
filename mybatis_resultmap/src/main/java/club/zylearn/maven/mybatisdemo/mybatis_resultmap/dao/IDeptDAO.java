package club.zylearn.maven.mybatisdemo.mybatis_resultmap.dao;

import java.util.List;

import club.zylearn.maven.mybatisdemo.mybatis_resultmap.vo.Dept;

public interface IDeptDAO {
	public Dept findById(Integer deptno);
	public List<Dept> findAll();
	public Dept findByIdDeep(Integer deptno);
	public List<Dept> findAllDeep();
}
