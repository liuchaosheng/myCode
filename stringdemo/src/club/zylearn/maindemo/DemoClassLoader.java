package club.zylearn.maindemo;

import java.io.File;
import java.lang.reflect.Method;

import club.zylean.classloader.MyClassLoader;

public class DemoClassLoader {

	public static void main(String[] args) throws Exception {
		// 主方法执行，则由application class loader来加载主类
		MyClassLoader loader = new MyClassLoader("e:" + File.separator + "javademo");
		
		// 使用自定义的类加载器来加载某类
//		Class<?> quickSortClass = loader.loadClass("QuickSort");
//		System.out.println(quickSortClass);
//		System.out.println(quickSortClass.getClassLoader());
		
		// 调用排序方法
		int[] array = {3,5,2,1,10,9,5,6,8};
//		Method method = quickSortClass.getDeclaredMethod("quickSort",int[].class,int.class,int.class);
//		method.invoke(null, array,0,array.length - 1);
//		for(int i = 0 ; i < array.length ; i++) {
//			System.out.print(array[i] + "\t");
//		}
		
		// 设置线程上下文的类加载器
		Thread.currentThread().setContextClassLoader(loader);
		
		// 使用线程上下文类加载器加载类
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		Class<?> clazz = cl.loadClass("QuickSort");
		Method method = clazz.getDeclaredMethod("quickSort", int[].class,int.class,int.class);
		method.invoke(null, array,0,array.length - 1);
		for(int i = 0 ; i < array.length ; i++) {
			System.out.print(array[i] + "\t");
		}
	}

}
