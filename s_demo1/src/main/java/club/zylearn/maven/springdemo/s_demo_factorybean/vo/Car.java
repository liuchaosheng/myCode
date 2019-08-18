package club.zylearn.maven.springdemo.s_demo_factorybean.vo;

import java.io.Serializable;

public class Car implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer cid ;
	private String cname ;
	private Double speed ;
	
	private Person person ;
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Double getSpeed() {
		return speed;
	}
	public void setSpeed(Double speed) {
		this.speed = speed;
	}
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	@Override
	public String toString() {
		return "Car [cid=" + cid + ", cname=" + cname + ", speed=" + speed + "]";
	}
}
