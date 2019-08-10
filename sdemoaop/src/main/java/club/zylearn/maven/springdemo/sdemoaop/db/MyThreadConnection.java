package club.zylearn.maven.springdemo.sdemoaop.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyThreadConnection {
	@Autowired
	private DataSource dataSource ;
	private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>() ;
	public Connection getThreadConnection() {
		Connection conn = threadLocal.get() ;
		if(conn == null) {
			try {
				conn = dataSource.getConnection() ;
				threadLocal.set(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn ;
	}
	public void closeThreadConnection() {
		Connection conn = threadLocal.get() ;
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				threadLocal.remove();
			}
		}
	}
}
