package club.zylearn.maven.mybatisdemo.mybatis_resultmap.factory;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyLocalSqlSessionFactory {
	private static ThreadLocal<SqlSession> sqlSessionLocal = new ThreadLocal<>() ;
	private static SqlSessionFactory factory = null ; // 保证程序中只有一个SqlSessionFactory实例
	static {
		// 使用静态块初始化SqlSessionFactory
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("初始化SqlSessionFactory实例失败");
		}
	}
	/**
	 * 该方法用于取得线程私有的SqlSession实例
	 * 如果第一次获取则需要创建
	 * @return
	 */
	public static SqlSession getLocalSqlSession() {
		SqlSession sqlSession= sqlSessionLocal.get() ;
		if(sqlSession == null) {
			sqlSession = factory.openSession() ;
			sqlSessionLocal.set(sqlSession);
		}
		return sqlSession ;
	}
	/**
	 * 该方法用于关闭线程私有的SqlSession实例
	 * 而且移除存储在ThreadLocal中的SqlSession实例
	 */
	public static void closeLocalSqlSession() {
		SqlSession sqlSession= sqlSessionLocal.get() ;
		if(sqlSession != null) {
			sqlSession.close();
			sqlSessionLocal.remove(); 
		}
	}
}
