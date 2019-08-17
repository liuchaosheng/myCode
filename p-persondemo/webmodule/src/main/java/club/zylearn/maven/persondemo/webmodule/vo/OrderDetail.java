package club.zylearn.maven.persondemo.webmodule.vo;

public class OrderDetail {
	private String proname ;
	private Integer count ;
	private Double allprice ;
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getAllprice() {
		return allprice;
	}
	public void setAllprice(Double allprice) {
		this.allprice = allprice;
	}
	@Override
	public String toString() {
		return "产品 [名称=" + proname + ", 购买数量=" + count + ", 子价格=" + allprice + "]";
	}
}
