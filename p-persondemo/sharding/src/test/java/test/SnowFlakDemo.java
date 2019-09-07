package test;

import org.junit.Test;

import club.zylearn.sharding.utils.MySnowFlake;
import pro.mickey.MickeySnowflake;

public class SnowFlakDemo {
	@Test
	public void test01() {
		System.out.println(MySnowFlake.getInstance().generateKey());
		System.out.println(MySnowFlake.getInstance().generateKey());
		System.out.println(MySnowFlake.getInstance().generateKey());
	}
}
