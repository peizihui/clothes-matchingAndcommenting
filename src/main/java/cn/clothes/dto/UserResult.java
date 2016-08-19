package cn.clothes.dto;

/**
 * Created by nerd on 2016/7/5.
 */
public class UserResult {
    String userName;

	int type;

	int code;
    String msg;
    String icon;
    public int getCode() {
        return code;
    }
    public String getIcon() {
        return icon;
    }

    public String getMsg() {
        return msg;
    }

    public int getType() {
		return type;
	}

    public String getUserName() {
        return userName;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setType(int type) {
		this.type = type;
	}

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
