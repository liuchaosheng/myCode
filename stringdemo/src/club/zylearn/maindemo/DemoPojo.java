package club.zylearn.maindemo;

import java.util.ArrayList;
import java.util.List;

import club.zylearn.vo.Item;
import club.zylearn.vo.Product;
import club.zylearn.vo.SubItem;

public class DemoPojo {

	public static void main(String[] args) {
		// 初始化产品信息
		Product p2 = new Product(2, "小车车", 168.0, 10);
		Product p3 = new Product(3, "牛栏山", 15.0, 20);
		Product p4 = new Product(4, "小面包", 5.5, 100);
		Product p5 = new Product(5, "机器人", 300.0, 5);
		Product p6 = new Product(6, "冰箱", 1000.0, 10);
		Product p7 = new Product(7, "面粉", 3.5, 20);
		Product p8 = new Product(8, "别克", 200000, 1);
		Product p9 = new Product(9, "小辣狗", 0.5, 1000);
		Product p10 = new Product(10, "杠杆", 220, 10);

		// 初始化总分类信息
		Item item1 = new Item(10, "吃的");
		Item item2 = new Item(20, "玩的");
		Item item3 = new Item(30, "用的");

		// 子分类
		SubItem sitem1 = new SubItem(100, "小小零食");
		SubItem sitem2 = new SubItem(101, "主食");
		
		SubItem sitem3 = new SubItem(102,"儿童玩具");
		SubItem sitem4 = new SubItem(103,"大人玩具");
		
		SubItem sitem5 = new SubItem(104,"家电");
		SubItem sitem6 = new SubItem(105,"汽车");
		
		// 初始化对象间的关系
		
		// 设置子分类和分类之间的对应关系
		List<SubItem> subItems = new ArrayList<SubItem>();
		subItems.add(sitem1);
		subItems.add(sitem2);
		item1.setSubItems(subItems);
		sitem1.setItem(item1);
		sitem2.setItem(item1);
		
		subItems = new ArrayList<SubItem>();
		subItems.add(sitem3);
		subItems.add(sitem4);
		item2.setSubItems(subItems);
		sitem3.setItem(item2);
		sitem4.setItem(item2);
		
		subItems = new ArrayList<SubItem>();
		subItems.add(sitem5);
		subItems.add(sitem6);
		item3.setSubItems(subItems);
		sitem5.setItem(item3);
		sitem6.setItem(item3);
		
		// 设置产品和子分类之间的对应关系
		List<Product> products = new ArrayList<Product>();
		products.add(p4);
		products.add(p9);
		sitem1.setProducts(products);
		p4.setSubItem(sitem1);
		p9.setSubItem(sitem1);
		
		products = new ArrayList<Product>();
		products.add(p3);
		products.add(p7);
		sitem2.setProducts(products);
		p3.setSubItem(sitem2);
		p7.setSubItem(sitem2);
		
		products = new ArrayList<Product>();
		products.add(p2);
		products.add(p5);
		sitem3.setProducts(products);
		p2.setSubItem(sitem3);
		p5.setSubItem(sitem3);
		
		products = new ArrayList<Product>();
		products.add(p10);
		sitem3.setProducts(products);
		p10.setSubItem(sitem4);
		
		products = new ArrayList<Product>();
		products.add(p6);
		sitem5.setProducts(products);
		p6.setSubItem(sitem5);
		
		products = new ArrayList<Product>();
		products.add(p8);
		sitem6.setProducts(products);
		p8.setSubItem(sitem6);
		
		// 设置主分类和产品的关系
		products = new ArrayList<Product>();
		products.add(p3);
		products.add(p4);
		products.add(p7);
		products.add(p9);
		item1.setProducts(products);
		p3.setItem(item1);
		p4.setItem(item1);
		p7.setItem(item1);
		p9.setItem(item1);
		
		products = new ArrayList<Product>();
		products.add(p2);
		products.add(p5);
		products.add(p10);
		item2.setProducts(products);
		p2.setItem(item2);
		p5.setItem(item2);
		p10.setItem(item2);
		
		products = new ArrayList<Product>();
		products.add(p6);
		products.add(p8);
		item3.setProducts(products);
		p6.setItem(item3);
		p8.setItem(item3);
		
		// 查询一个主分类对应的子分类
		System.out.println(item1);
		for(SubItem subItem : item1.getSubItems()) {
			System.out.println("\t -| " + subItem);
		}
	}

}
