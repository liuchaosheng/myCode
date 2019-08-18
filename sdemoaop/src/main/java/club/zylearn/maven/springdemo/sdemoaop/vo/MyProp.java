package club.zylearn.maven.springdemo.sdemoaop.vo;

// 测试spring会不会取System.getProperties()中的属性
public class MyProp {
	private String username;
	private String encoding;

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "MyProp [username=" + username + ", encoding=" + encoding + "]";
	}
}
