package club.zylearn.maven.persondemo.webmodule.controller;

public class TestRequest {
	private String name;
	private Integer age;
	private Double sal;
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
		return "TestRequest [name=" + name + ", age=" + age + ", sal=" + sal + "]";
	}
}
