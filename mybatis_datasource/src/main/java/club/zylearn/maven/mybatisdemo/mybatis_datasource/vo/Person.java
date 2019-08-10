package club.zylearn.maven.mybatisdemo.mybatis_datasource.vo;


import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer pid ;
	private Integer age ;
	private String name ;
	private Double sal ;
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
		//String birthdayStr = new SimpleDateFormat("yyyy-MM-dd").format(this.birthday) ;
		return "Person [pid=" + pid + ", age=" + age + ", name=" + name + ", sal=" + sal + ", birthday=" + birthday
				+ "]";
	}
}
