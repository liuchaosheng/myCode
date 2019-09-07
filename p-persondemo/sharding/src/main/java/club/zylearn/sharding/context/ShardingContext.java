package club.zylearn.sharding.context;

import java.util.HashMap;
import java.util.Map;

public class ShardingContext {
	private Map<String,Object> messageMap = null;
	private static final ThreadLocal<ShardingContext> CONTEXT = new ThreadLocal<ShardingContext>();
	private ShardingContext() {
		// 初始化线程上下文
		messageMap = new HashMap<String,Object>();
		CONTEXT.set(this);
	}
	// 获取当前线程上下文对象
	public static ShardingContext getCurrentContext() {
		ShardingContext context = CONTEXT.get();
		if(context == null) {
			// 如果当前线程还没有上下文对象则创建
			context = new ShardingContext();
			CONTEXT.set(context);
		}
		return context;
	}
	// 设置共享属性
	public void setSharedParam(String key,Object value) {
		this.messageMap.put(key, value);
	}
	// 取出共享属性
	public <T> T getSharedParam(String key,Class<T> clazz) {
		return (T)messageMap.get(key);
	}
}
