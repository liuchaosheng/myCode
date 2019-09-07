package club.zylearn.sharding.vo;

public class Person {
	private Long id;
	private String pname;
	private Integer age;
	private String note;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "人员信息 [id=" + id + ", pname=" + pname + ", age=" + age + ", note=" + note + "]";
	}
}
