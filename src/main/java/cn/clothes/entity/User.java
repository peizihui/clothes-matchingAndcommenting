package cn.clothes.entity;

/**
 * Created by nerd on 2016/6/30.
 */
public class User {
	private Long id;
    private int permission;

	private String userName;

	private String password;
    private String icon;
    private String email;
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

    public int getPermission() {
        return permission;
    }

    public String getUserName() {
        return userName;
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

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "permission=" + permission +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", icon='" + icon + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
