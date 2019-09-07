package club.zylearn.sharding.mybatis.interceptor;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;


import club.zylearn.sharding.context.ShardingContext;

@Intercepts({
	@Signature(type=StatementHandler.class,method="prepare",args= {Connection.class,Integer.class})
})
public class SqlReplaceInteceptor implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// 获取ShardingContext中的共享的id属性
		long id = ShardingContext.getCurrentContext().getSharedParam("id", Long.class);
		// 通过取模运算计算表名称
		int tableIndex = (int)(id % 5);
		// 构造tableName
		String tableName = "person_" + tableIndex; 
		// 取出sql语句
		MetaObject metaObject = SystemMetaObject.forObject(invocation.getTarget());
		String sql = (String) metaObject.getValue("parameterHandler.boundSql.sql");
		// 判断是否包含tableName的站位字符串
		if(sql.contains("tableName")) {
			sql = sql.replace("tableName", tableName);
		}
		// 设置sql
		metaObject.setValue("parameterHandler.boundSql.sql",sql);
		
		// 调用目标对象的方法
		return invocation.proceed();
	}
	@Override
	public Object plugin(Object target) {
		// mybatis拦截器标准代理实现
		return Plugin.wrap(target, this);
	}
	@Override
	public void setProperties(Properties properties) {
	}
}
