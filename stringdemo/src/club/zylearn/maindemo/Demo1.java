package club.zylearn.maindemo;

public class Demo1 {
	private static String msg = "初始化的信息" ;
	static {
		System.out.println("静态块构造前：" + msg);
		msg = "静态块构造";
		System.out.println("静态块构造后：" + msg);
		System.out.println("String类的加载器：" + msg.getClass().getClassLoader());
	}
	public static void main(String[] args) {
		// 1、String类的特点：String类也是JAVA的一个类，只是该类比较特殊
		// 2、所有语言几乎都使用“”来表示字符串，但是JAVA中在类加载的时候将字符串信息设置成String类的匿名对象。
		String strMsg = "helloWorld";
		System.out.println(strMsg);
		Demo1 demo1 = new Demo1();
		System.out.println("主类Demo1的加载器：" + demo1.getClass().getClassLoader());
		
		// 关于类加载器的知识：
		/**
		 * 1、Bootstrap class loader  ==》 系统rt.jar  用于加载系统自带的jar包
		 * 2、Extensions class loader  ==》 ext/*.jar 系统扩展的jar  用于加载系统扩展的jar包
		 * 3、Application class loader   ==》 class path  用于加载应用程序classpath执行的路径。
		 *     上述的加载器使用了双亲委托机制来解决类安全的问题。
		 *     	也就是说当加载类的时候会先交给父加载器来加载，不行再自己加载。
		 *     （而三个类的层级关系是靠组合来实现的）
		 * 4、自定义类加载器
		 */
		
		
	}
}

class Person{
	static {
		System.out.println("person 类被初始化了 ");
	}
	private String name;
	private Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
