package cn.clothes.dto;

/**
 * Created by nerd on 2016/7/5.
 */
public class UserResult {
    String userName;
    int permission;
    int code;
    String msg;
    String icon;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "UserResult{" +
                "userName='" + userName + '\'' +
                ", permission=" + permission +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
