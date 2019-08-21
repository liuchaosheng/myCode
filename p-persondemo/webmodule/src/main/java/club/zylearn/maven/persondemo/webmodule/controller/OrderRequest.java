package club.zylearn.maven.persondemo.webmodule.controller;

import java.util.List;

public class OrderRequest {
	private Integer pid;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	private List<Integer> proids;
	private List<Integer> counts;
	public List<Integer> getProids() {
		return proids;
	}
	public void setProids(List<Integer> proids) {
		this.proids = proids;
	}
	public List<Integer> getCounts() {
		return counts;
	}
	public void setCounts(List<Integer> counts) {
		this.counts = counts;
	}
	@Override
	public String toString() {
		return "OrderRequest [pid=" + pid + ", proids=" + proids + ", counts=" + counts + "]";
	}
}
