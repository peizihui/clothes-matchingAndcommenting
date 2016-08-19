package cn.clothes.entity;

/**
 * Created by nerd on 2016/6/30.
 */
public class User {
	private Long id;
	private String userName;
	private String password;
	private String icon;
	private String email;
	private Integer type;
	private Long createTime;
	
	public enum USER_TYPE{
		/**
		 * 达人
		 */
		dresser(1),
		/**
		 * 点评师
		 */
		teacher(2);
		
		public Integer value;
		
		USER_TYPE(Integer value) {
			this.value = value;
		}
	}
	public Long getCreateTime() {
		return createTime;
	}
	public String getEmail() {
		return email;
	}
	public String getIcon() {
		return icon;
	}
	public Long getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public Integer getType() {
		return type;
	}
	public String getUserName() {
		return userName;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
    public void setId(Long id) {
		this.id = id;
	}
    public void setPassword(String password) {
		this.password = password;
	}
    public void setType(Integer type) {
		this.type = type;
	}
    public void setUserName(String userName) {
		this.userName = userName;
	}
   
}
