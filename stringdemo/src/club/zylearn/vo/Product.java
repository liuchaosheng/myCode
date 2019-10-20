package club.zylearn.vo;

public class Product {
	private int pid;
	private String pname;
	private double price;
	private int count;
	private SubItem subItem;
	private Item item;

	public Product() {
	}

	public Product(int pid, String pname, double price, int count) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.count = count;
	}

	public SubItem getSubItem() {
		return subItem;
	}

	public void setSubItem(SubItem subItem) {
		this.subItem = subItem;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", count=" + count + "]";
	}
}
