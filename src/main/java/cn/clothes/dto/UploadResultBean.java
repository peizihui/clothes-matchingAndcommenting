package cn.clothes.dto;

public class UploadResultBean {
	private String iconPath;
	private Integer type;
	private String content;
	private String userName;
	private String userIcon;
	public String getContent() {
		return content;
	}
	public String getIconPath() {
		return iconPath;
	}
	public Integer getType() {
		return type;
	}
	public String getUserIcon() {
		return userIcon;
	}
	public String getUserName() {
		return userName;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
