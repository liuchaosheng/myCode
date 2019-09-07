package club.zylearn.sharding.datasource;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import club.zylearn.sharding.context.ShardingContext;
import club.zylearn.sharding.exception.COMException;

/**
 * 具有路由功能的dataSource
 * @author chaos
 *
 */
public class ShardingRoutingDataSource  extends AbstractRoutingDataSource{
	public ShardingRoutingDataSource() {
		super();
		try {
			// 为父类初始化数据源列表
			// 初始化两个数据源并设置给父类对象
			ComboPooledDataSource dataSourceMysql = new ComboPooledDataSource();
			dataSourceMysql.setJdbcUrl("jdbc:mysql://localhost:3306/demo");
			dataSourceMysql.setDriverClass("com.mysql.jdbc.Driver");
			dataSourceMysql.setUser("root");
			dataSourceMysql.setPassword("root");
			
			ComboPooledDataSource dataSourceOracle = new ComboPooledDataSource();
			dataSourceOracle.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:zylearn");
			dataSourceOracle.setDriverClass("oracle.jdbc.driver.OracleDriver");
			dataSourceOracle.setUser("scott");
			dataSourceOracle.setPassword("oracle");
			
			Map<Object,Object> targetDataSourceMap = new HashMap<Object,Object>();
			targetDataSourceMap.put("db_00", dataSourceMysql);
			targetDataSourceMap.put("db_01", dataSourceOracle);
			// 设置能路由的所有数据源信息
			super.setTargetDataSources(targetDataSourceMap);
			// 设置默认的数据源
			super.setDefaultTargetDataSource(dataSourceMysql);
		} catch (Throwable e) {
			System.out.println(new COMException("初始化数据源出错",e));
			e.printStackTrace();
		}
	}
	@Override
	protected Object determineCurrentLookupKey() {
		// 获取ShardingContext中的共享的id属性
		long id = ShardingContext.getCurrentContext().getSharedParam("id", Long.class);
		
		// 通过取模运算计算数据源名称
		int dbIndex = (int)(id % 2);
		System.out.println(dbIndex + "========================================");
		return "db_0" + dbIndex;
	}
	
}
