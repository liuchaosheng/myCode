package club.zylearn.maven.springdemo.s_demo_factorybean.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	@Value("100001")
	private Integer pid ;
	@Value("30")
	private Integer age ;
	@Value("value-test 朝阳")
	private String name ;
	@Value("9000.0")
	private Double sal ;
	@Value("#{new java.util.Date()}")
	private Date birthday ;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		String birthdayStr = new SimpleDateFormat("yyyy-MM-dd").format(this.birthday) ;
		return "Person [pid=" + pid + ", age=" + age + ", name=" + name + ", sal=" + sal + ", birthday=" + birthdayStr
				+ "]";
	}
}
