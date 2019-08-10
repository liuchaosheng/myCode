package club.zylearn.maven.mybatisdemo.m_demo1.factory;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// 创建SqlSession的实例工厂
public class MySqlSessionFactory {		
	// 在静态域中保留SqlSesssionFactory的引用
	private static SqlSessionFactory factory = null ;
	
	static {
		// 在静态块中初始化 factory
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			factory = new SqlSessionFactoryBuilder().build(reader) ;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// 使用 ThreadLocal来为每个线程设置一个SqlSession
	private static ThreadLocal<SqlSession> sessionLocal = new ThreadLocal<SqlSession>() ;
	
	// 取得线程独有SqlSession
	public static SqlSession getSqlSession() {
		SqlSession session = sessionLocal.get() ;
		if(session == null) {
			session = factory.openSession() ;
			sessionLocal.set(session);
		}
		return session ;
	}
	
	// 关闭当前线程的SqlSession
	public static void closeSqlSession() {
		SqlSession session = sessionLocal.get() ;
		if(session != null) {
			sessionLocal.remove(); 
			session.close();
		}
	}
}
