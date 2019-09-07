package club.zylearn.maven.mybatisdemo.mybatis_resultmap.vo;

public class Emp {
	private Integer empno;
	private String ename;
	private Integer age;
	private Double sal;
	private Dept dept;
	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
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
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "雇员 [empno=" + empno + ", ename=" + ename + ", age=" + age + ", sal=" + sal + "]";
	}
}
