public class Hello{
	public static void print(Object o){
		System.out.println(o) ;
	}
	public static void main(String args[]){
		Object obj = new java.util.Date() ;
		print(obj) ;
	}
	public static int add(int data1,int data2){
		return data1 + data2 ;
	}
}