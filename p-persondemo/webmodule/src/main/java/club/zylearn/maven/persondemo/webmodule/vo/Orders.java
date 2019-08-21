package club.zylearn.maven.persondemo.webmodule.vo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Orders {
	private Integer oid ;
	private Double allPrice ;
	private Date createTime ;
	private String createTimeStr;
	public String getCreateTimeStr() {
		return createTimeStr;
	}
	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	private Person person; // 订单所属人
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
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
	public Double getAllPrice() {
		return allPrice;
	}
	public void setAllPrice(Double allPrice) {
		this.allPrice = allPrice;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
		if(createTime != null) {
			this.createTimeStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(createTime);
		}
	}
	@Override
	public String toString() {
		return "订单 [编号=" + oid + ", 总价=" + allPrice + ", 创建时间=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(createTime) + "]";
	}
}
