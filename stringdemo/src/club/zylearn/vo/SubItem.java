package club.zylearn.vo;

import java.util.List;

public class SubItem {
	private int sid;
	private String title;
	private Item item;
	private List<Product> products;

	public SubItem() {

	}

	public SubItem(int sid, String title) {
		super();
		this.sid = sid;
		this.title = title;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "SubItem [sid=" + sid + ", title=" + title + "]";
	}
}
