package club.zylearn.maindemo;

public class Demo2 {

	public static void main(String[] args) {
		// 本例演示了 String的基本方法
		String str = "2880joropgpshgsuusfjlduosugsgysuojo1h2hgh2ojo刘朝胜";
		
		// charAt
		char ch = str.charAt(str.length() - 1);
		System.out.println("最后一个索引对应的字符是：" + ch);
		
		// toCharArray
		char[] chArr = str.toCharArray();
		for(int i = 0 ; i < chArr.length ; i++) {
			System.out.print(chArr[i] + "\t");
		}
		System.out.println("");
		
		// new String()
		String newStr = new String(chArr,0,10);
		System.out.println(newStr);
		
		// java中的字符和字符串使用了UNICODE的编码方式
		// 所有转String的方式都是深拷贝而不是浅拷贝
		
	}
	
}
