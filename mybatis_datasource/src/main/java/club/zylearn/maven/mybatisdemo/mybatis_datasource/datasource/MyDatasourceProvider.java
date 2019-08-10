package club.zylearn.maven.mybatisdemo.mybatis_datasource.datasource;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.DataSourceFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

// 自定义数据源供mybatis使用
public class MyDatasourceProvider implements DataSourceFactory {
	private Properties props ;
	@Override
	public void setProperties(Properties props) {
		// mybatis会将配置文件配置的内容传入
		this.props = props ;
	}

	@Override
	public DataSource getDataSource() {
		// 初始化c3p0的数据源
		DataSource ds = null ;
		try {
			ComboPooledDataSource cpds = new ComboPooledDataSource() ;
			cpds.setJdbcUrl(props.getProperty("url"));
			cpds.setDriverClass(props.getProperty("driver"));
			cpds.setUser(props.getProperty("user"));
			cpds.setPassword(props.getProperty("password"));
			cpds.setInitialPoolSize(10);
			cpds.setMinPoolSize(10);
			cpds.setMaxPoolSize(10);
			System.out.println("执行了++++getDataSource");
			ds = cpds ;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		return ds ;
		
	}

}
