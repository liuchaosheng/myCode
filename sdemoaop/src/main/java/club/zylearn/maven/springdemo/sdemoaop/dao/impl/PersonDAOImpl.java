package club.zylearn.maven.springdemo.sdemoaop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import club.zylearn.maven.springdemo.sdemoaop.dao.IPersonDAO;
import club.zylearn.maven.springdemo.sdemoaop.db.MyThreadConnection;
import club.zylearn.maven.springdemo.sdemoaop.vo.Person;

@Repository
public class PersonDAOImpl implements IPersonDAO {
	@Autowired
	private MyThreadConnection mtc ;
	@Override
	public boolean doCreate(Person vo) throws Exception {
		Connection conn = mtc.getThreadConnection() ;
		String sql = "insert into person(name,age,birthday,sal) values(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql) ;
		ps.setString(1, vo.getName());
		ps.setInt(2, vo.getAge());
		ps.setTimestamp(3, new Timestamp(vo.getBirthday().getTime()));
		ps.setDouble(4, vo.getSal());
		int count = ps.executeUpdate() ;
//		throw new Exception("我的异常") ;
		return count > 0 ;
	}

	@Override
	public boolean doRemove(Integer id) throws Exception {
		Connection conn = mtc.getThreadConnection() ;
		String sql = "delete from person where pid=?";
		PreparedStatement ps = conn.prepareStatement(sql) ;
		ps.setInt(1, id);
		int count = ps.executeUpdate() ;
		return count > 0 ;
	}

	@Override
	public boolean doUpdate(Person vo) throws Exception {
		Connection conn = mtc.getThreadConnection() ;
		String sql = "update person set name=?,age=?,birthday=?,sal=? where pid=?";
		PreparedStatement ps = conn.prepareStatement(sql) ;
		ps.setString(1, vo.getName());
		ps.setInt(2, vo.getAge());
		ps.setTimestamp(3, new Timestamp(vo.getBirthday().getTime()));
		ps.setDouble(4, vo.getSal());
		ps.setInt(5, vo.getPid());
		int count = ps.executeUpdate() ;
		return count > 0 ;
	}

	@Override
	public Person findById(Integer id) throws Exception {
		Person person = null ;
		Connection conn = mtc.getThreadConnection() ;
		String sql = "select pid,name,age,birthday,sal from person where pid=?";
		PreparedStatement ps = conn.prepareStatement(sql) ;
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery() ;
		while(rs.next()) {
			person = new Person() ;
			person.setPid(rs.getInt(1));
			person.setName(rs.getString(2));
			person.setAge(rs.getInt(3));
			person.setBirthday(new java.util.Date(rs.getTimestamp(4).getTime()));
			person.setSal(rs.getDouble(5));
		}
		return person;
	}

	@Override
	public List<Person> findAll() throws Exception {
		List<Person> persons = new ArrayList<Person>() ;
		Connection conn = mtc.getThreadConnection() ;
		String sql = "select pid,name,age,birthday,sal from person";
		PreparedStatement ps = conn.prepareStatement(sql) ;
		ResultSet rs = ps.executeQuery() ;
		while(rs.next()) {
			Person person = new Person() ;
			person.setPid(rs.getInt(1));
			person.setName(rs.getString(2));
			person.setAge(rs.getInt(3));
			person.setBirthday(new java.util.Date(rs.getTimestamp(4).getTime()));
			person.setSal(rs.getDouble(5));
			persons.add(person) ;
		}
		return persons;
	}

}
