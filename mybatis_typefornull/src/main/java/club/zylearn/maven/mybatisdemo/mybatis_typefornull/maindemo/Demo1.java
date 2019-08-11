package club.zylearn.maven.mybatisdemo.mybatis_typefornull.maindemo;

import java.util.Date;

import club.zylearn.maven.mybatisdemo.mybatis_typefornull.dao.IPersonDAO;
import club.zylearn.maven.mybatisdemo.mybatis_typefornull.factory.MyLocalSqlSessionFactory;
import club.zylearn.maven.mybatisdemo.mybatis_typefornull.vo.Person;

public class Demo1 {

	public static void main(String[] args) throws Exception {
		IPersonDAO personDAO = MyLocalSqlSessionFactory.getLocalSqlSession().getMapper(IPersonDAO.class) ;
		try {
			// 插入单个
			Person vo = new Person() ;
			vo.setAge(null);
			vo.setName("mybatis_oracle");
			vo.setSal(4400.0);
			vo.setBirthday(new java.util.Date());
			personDAO.doCreate(vo) ;
			System.out.println(vo);
			
			// 修改单个
//			Person vo = new Person() ;
//			vo.setPid(8);
//			vo.setName("name-改变");
//			vo.setAge(20);
//			vo.setBirthday(new Date());
//			vo.setSal(3500.0);
//			personDAO.doUpdate(vo) ;
			
			// 删除单个
//			personDAO.doRemove(8) ;
			
			// 查询单个
//			Person vo = personDAO.findById(9) ;
//			System.out.println(vo);
			
			// 查询全部
//			List<Person> persons = personDAO.findAll() ;
//			for(Person vo : persons) {
//				System.out.println(vo);
//			}
			MyLocalSqlSessionFactory.getLocalSqlSession().commit();
		}catch(Exception e){
			MyLocalSqlSessionFactory.getLocalSqlSession().rollback();
			e.printStackTrace();
		}finally {
			MyLocalSqlSessionFactory.closeLocalSqlSession(); 
		}
	}
}
