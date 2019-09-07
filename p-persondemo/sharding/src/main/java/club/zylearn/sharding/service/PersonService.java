package club.zylearn.sharding.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.zylearn.sharding.context.ShardingContext;
import club.zylearn.sharding.dao.IPersonDAO;
import club.zylearn.sharding.utils.MySnowFlake;
import club.zylearn.sharding.vo.Person;

@Service
public class PersonService {
	@Autowired
	private IPersonDAO personDAO;
	public void add(Person vo) {
		// 第一步 产生id 
		long id = MySnowFlake.getInstance().generateKey();
		vo.setId(id);
		// 第二步 设置上下文
		ShardingContext.getCurrentContext().setSharedParam("id", id);
		// 第三步 执行 dao方法
		personDAO.doCreate(vo);
	}
	
	public Person getOne(Long id) {
		// 第一步 设置 上下文
		ShardingContext.getCurrentContext().setSharedParam("id", id);
		
		// 第二步 查询
		return personDAO.findById(id);
	}
	
	public void edit(Person vo) {
		// 第一步 设置 上下文
		ShardingContext.getCurrentContext().setSharedParam("id", vo.getId());
		
		// 第二步 修改
		System.out.println("修改了" + personDAO.doUpdate(vo));
	}
	
}
