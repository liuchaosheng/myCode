package club.zylearn.maven.persondemo.webmm.factory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

// 创建SqlSession的实例工厂
@Component
public class MySqlSessionFactory {
	//@Value("classpath:club/zylearn/mybatis-config.xml")
	private Resource resource;
	
	private SqlSessionFactory factory = null ;
	
	// 使用 ThreadLocal来为每个线程设置一个SqlSession
	private static ThreadLocal<SqlSession> sessionLocal = new ThreadLocal<SqlSession>() ;
	
	public MySqlSessionFactory() throws Exception{
		resource = new DefaultResourceLoader().getResource("classpath:club/zylearn/mybatis-config.xml") ;
		// 构建SqlSessionFactory
		factory = new SqlSessionFactoryBuilder().build(resource.getInputStream()) ;
		
	}
	
	// 取得线程独有SqlSession
	public SqlSession getSqlSession() {
		SqlSession session = sessionLocal.get() ;
		if(session == null) {
			session = factory.openSession() ;
			sessionLocal.set(session);
		}
		return session ;
	}
	
	// 关闭当前线程的SqlSession
	public void closeSqlSession() {
		SqlSession session = sessionLocal.get() ;
		if(session != null) {
			sessionLocal.remove(); 
			session.close();
		}
	}
}
