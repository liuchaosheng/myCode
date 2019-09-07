package club.zylearn.sharding.utils;

import pro.mickey.MickeySnowflake;

/**
 * 单例的SnowFlak主键id生成器
 * @author chaos
 *
 */
public class MySnowFlake {
	private MickeySnowflake snowFlake = null;
	private MySnowFlake(){
		//私有化构造器 只是测试使用
		snowFlake = new MickeySnowflake(5555555);
	}
	public long generateKey() {
		return System.currentTimeMillis();
	}
	private static final MySnowFlake INSTANCE = new MySnowFlake(); 
	public static MySnowFlake getInstance() {
		return INSTANCE;
	}
}
