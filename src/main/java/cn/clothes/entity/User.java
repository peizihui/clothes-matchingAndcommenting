package cn.clothes.entity;

/**
 * Created by nerd on 2016/6/30.
 */
public class User {
    private int permission;
    private String userName;
    private String password;
    private String icon;
    private String email;

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
