package club.zylearn.maven.persondemo.webmodule.controller;

import club.zylearn.maven.persondemo.webmodule.vo.Dept;

public class TestRequestMulty {
	private String name;
	private Integer age;
	private Double sal;
	private Dept dept;
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
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
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "TestRequestMulty [name=" + name + ", age=" + age + ", sal=" + sal + ", dept=" + dept + "]";
	}
}
