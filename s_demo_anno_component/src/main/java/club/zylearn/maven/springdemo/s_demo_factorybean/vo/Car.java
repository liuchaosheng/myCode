package club.zylearn.maven.springdemo.s_demo_factorybean.vo;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car implements Serializable {

	private static final long serialVersionUID = 1L;
	@Value("101")
	private Integer cid ;
	@Value("宝马5系")
	private String cname ;
	@Value("350.0")
	private Double speed ;
	@Autowired
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
