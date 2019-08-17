package club.zylearn.maven.persondemo.webmodule.vo;

import java.util.List;

public class Product {
	private Integer proid ;
	private String proname ;
	private Double price ;
	private Integer count ;
	private Double oriprice ;
	private List<Orders> orders ;
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	public Integer getProid() {
		return proid;
	}
	public void setProid(Integer proid) {
		this.proid = proid;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getOriprice() {
		return oriprice;
	}
	public void setOriprice(Double oriprice) {
		this.oriprice = oriprice;
	}
	@Override
	public String toString() {
		return "商品 [编号=" + proid + ", 名称=" + proname + ", 价格=" + price + ", 数量=" + count
				+ ", 原价=" + oriprice + "]";
	}
}
