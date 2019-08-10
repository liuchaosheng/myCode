package club.zylearn.maven.springdemo.s_demo1.vo;

import java.io.Serializable;
import java.util.List;

public class Company implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Person> persons ;
	
	private String cname ;
	private String address ;

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	@Override
	public String toString() {
		return "Company [cname=" + cname + ", address=" + address + "]";
	}
}
