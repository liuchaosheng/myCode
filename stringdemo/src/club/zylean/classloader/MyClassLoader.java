package club.zylean.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 自定义类加载器
 * @author chaos
 * @since []
 * @version []
 */
public class MyClassLoader extends ClassLoader {
	/*
	 * 自定义类加载器的加载目录
	 */
	private String baseDir;
	
	/*
	 * 传入加载目录的构造器
	 */
	public MyClassLoader(String baseDir) {
		this.baseDir = baseDir;
	}
	
	/*
	 * 默认构造器
	 */
	public MyClassLoader() {
		// 获取用户工作目录
		String userDir = System.getProperty("user.dir");
		if(userDir != null) {
			baseDir = userDir;
		}else {
			baseDir = "e:" + File.separator + "javademo";
		}
	}
	
	/**
	 * 自定义加载类的方法
	 */
	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		Class<?> clazz = null;
		try {
			clazz = super.getParent().loadClass(name);
		} catch (ClassNotFoundException e) {
			System.out.println("系统加载器加载失败！");
		}
		if(clazz == null) {
			// 说明父加载器（这里是application class loader加载）没有加载成功
			// 构造该类所在目录
			String realPath = baseDir + File.separator + name.replace('.', File.separatorChar) + ".class";
			
			// 读取类信息加载到内存
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			InputStream in = null;
			try {
				 in = new FileInputStream(realPath);
				 byte[] buf = new byte[1024];
				 // 读取文件内容并放入字节输出流中
				 int len = 0;
				 while((len = in.read(buf)) != -1){
					 baos.write(buf,0,len);
				 }
				 // 将baos中数据编程字节数组
				 byte[] retByte = baos.toByteArray();
				 
				 // 对加载进来的数据进行Class对象的定义
				 clazz = super.defineClass(name, retByte, 0, retByte.length);
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				if(in != null) {
					try {
						in.close();
					} catch (IOException e) {
					}
				}
			}
			
		}
		return clazz;
	}
}
