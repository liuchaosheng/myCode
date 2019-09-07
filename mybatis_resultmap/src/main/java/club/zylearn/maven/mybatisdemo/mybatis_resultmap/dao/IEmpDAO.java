package club.zylearn.maven.mybatisdemo.mybatis_resultmap.dao;

import java.util.List;

import club.zylearn.maven.mybatisdemo.mybatis_resultmap.vo.Emp;

public interface IEmpDAO {
	public List<Emp> findEmpsByDeptno(Integer deptno);
}
