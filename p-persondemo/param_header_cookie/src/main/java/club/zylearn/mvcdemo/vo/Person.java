package club.zylearn.mvcdemo.vo;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private Integer pid;
	private String name;
	private Integer age;
	private Dept dept;
	private List<String> msgs = new ArrayList<String>();
	
	public List<String> getMsgs() {
		return msgs;
	}
	public void setMsgs(List<String> msgs) {
		this.msgs = msgs;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", name=" + name + ", age=" + age + ", dept=" + dept + ", msgs=" + msgs + "]";
	}
}
