package club.zylearn.maven.springdemo.s_demo1.vo;

import java.io.Serializable;
import java.util.Arrays;

public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer bid ;
	private Double price ;
	private String title ;
	private String[] content ;
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String[] getContent() {
		return content;
	}
	public void setContent(String[] content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", price=" + price + ", title=" + title + ", content=" + Arrays.toString(content)
				+ "]";
	}
}
