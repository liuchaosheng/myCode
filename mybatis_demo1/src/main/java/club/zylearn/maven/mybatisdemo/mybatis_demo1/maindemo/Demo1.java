package club.zylearn.maven.mybatisdemo.mybatis_demo1.maindemo;

import java.util.List;

import club.zylearn.maven.mybatisdemo.mybatis_demo1.dao.IPersonDAO;
import club.zylearn.maven.mybatisdemo.mybatis_demo1.dao.impl.PersonDAOImpl;
import club.zylearn.maven.mybatisdemo.mybatis_demo1.factory.MyLocalSqlSessionFactory;
import club.zylearn.maven.mybatisdemo.mybatis_demo1.vo.Person;

public class Demo1 {

	public static void main(String[] args) throws Exception {
		IPersonDAO personDAO = new PersonDAOImpl() ;
		try {
			// 插入单个
//			Person vo = new Person() ;
//			vo.setAge(40);
//			vo.setName("mybatis_demo1");
//			vo.setSal(4000.0);
//			vo.setBirthday(new java.util.Date());
//			personDAO.doCreate(vo) ;
			
			// 修改单个
//			Person vo = new Person() ;
//			vo.setPid(213);
//			vo.setName("name-改变");
//			vo.setAge(20);
//			vo.setBirthday(new Date());
//			vo.setSal(3500.0);
//			personDAO.doUpdate(vo) ;
			
			// 删除单个
//			personDAO.doRemove(212) ;
			
			// 查询单个
//			Person vo = personDAO.findById(213) ;
//			System.out.println(vo);
			
			// 查询全部
			List<Person> persons = personDAO.findAll() ;
			for(Person vo : persons) {
				System.out.println(vo);
			}
			
			MyLocalSqlSessionFactory.getLocalSqlSession().commit();
		}catch(Exception e){
			MyLocalSqlSessionFactory.getLocalSqlSession().rollback();
		}finally {
			MyLocalSqlSessionFactory.closeLocalSqlSession(); 
		}
	}
}
