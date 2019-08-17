package club.zylearn.maven.persondemo.webmodule.vo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Orders {
	private Integer oid ;
	private Double allprice ;
	private Date createTime ;
	private List<OrderDetail> orderDetails;
	public List<OrderDetail> getOrderDetials() {
		return orderDetails;
	}
	public void setOrderDetials(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Double getAllprice() {
		return allprice;
	}
	public void setAllprice(Double allprice) {
		this.allprice = allprice;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "订单 [编号=" + oid + ", 总价=" + allprice + ", 创建时间=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(createTime) + "]";
	}
}
