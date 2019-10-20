package club.zylearn.vo;

import java.util.List;

public class Item {
	private int iid;
	private String title;
	private List<Product> products;
	private List<SubItem> subItems;

	public Item() {

	}

	public Item(int iid, String title) {
		super();
		this.iid = iid;
		this.title = title;
	}

	public List<SubItem> getSubItems() {
		return subItems;
	}

	public void setSubItems(List<SubItem> subItems) {
		this.subItems = subItems;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public int getIid() {
		return iid;
	}

	public void setIid(int iid) {
		this.iid = iid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Item [iid=" + iid + ", title=" + title + "]";
	}
}
