package cn.clothes.dto;
/**
 * 基础信息
 * @author clq
 *
 */
public class BaseBean {
	public String getIsSuccess() {
		return isSuccess;
	}
	public void setIsSuccess(String isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	private String isSuccess;
	private String cause;
}
