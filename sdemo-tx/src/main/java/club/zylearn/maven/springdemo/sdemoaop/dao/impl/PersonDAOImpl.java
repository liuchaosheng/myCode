package club.zylearn.maven.springdemo.sdemoaop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.ConnectionHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import club.zylearn.maven.springdemo.sdemoaop.dao.IPersonDAO;
import club.zylearn.maven.springdemo.sdemoaop.vo.Person;

@Repository
public class PersonDAOImpl implements IPersonDAO {
	@Autowired
	DataSource dataSource ;
	@Override
	public boolean doCreate(Person vo) throws Exception {
		System.out.println("+++++++++++++++");
		Connection conn = getSpringTransactionConnection() ;
		String sql = "insert into person(name,age,birthday,sal) values(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql) ;
		ps.setString(1, vo.getName());
		ps.setInt(2, vo.getAge());
		ps.setTimestamp(3, new Timestamp(vo.getBirthday().getTime()));
		ps.setDouble(4, vo.getSal());
		int count = ps.executeUpdate() ;
		throw new RuntimeException("我的异常") ;
//		return false ;
	}

	@Override
	public boolean doRemove(Integer id) throws Exception {
		Connection conn = getSpringTransactionConnection() ;
		String sql = "delete from person where pid=?";
		PreparedStatement ps = conn.prepareStatement(sql) ;
		ps.setInt(1, id);
		int count = ps.executeUpdate() ;
		return count > 0 ;
	}

	@Override
	public boolean doUpdate(Person vo) throws Exception {
		Connection conn = getSpringTransactionConnection() ;
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
		Connection conn = getSpringTransactionConnection() ;
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
		Connection conn = getSpringTransactionConnection() ;
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
	// 该处是重点代码
	// 要跟spring的事务产生关系就需要这样取得连接对象
	public Connection getSpringTransactionConnection() {
		ConnectionHolder ch = (ConnectionHolder)TransactionSynchronizationManager.getResource(dataSource) ;
		Connection conn = ch.getConnection() ;
		return conn ;
	}

}
