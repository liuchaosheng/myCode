package club.zylearn.maven.persondemo.webmodule.controller;

// 基础的返回对象
public class BaseResponse {
	private Integer retCode;
	private String msg;
	public Integer getRetCode() {
		return retCode;
	}
	public void setRetCode(Integer retCode) {
		this.retCode = retCode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "BaseResponse [retCode=" + retCode + ", msg=" + msg + "]";
	}
}
