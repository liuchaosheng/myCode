public class Hello{
	public static void print(Object o){
		System.out.println(o) ;
	}
	public static void main(String args[]){
		Object obj = new java.util.Date() ;
		print(obj) ;
	}
}