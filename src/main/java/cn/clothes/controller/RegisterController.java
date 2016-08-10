package cn.clothes.controller;

import cn.clothes.dto.UserResult;
import cn.clothes.entity.User;
import cn.clothes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by nerd on 2016/7/6.
 */
@Controller
@RequestMapping("/user")
public class RegisterController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET
            , produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public UserResult register(@RequestParam("permission") int permission, @RequestParam("userName") String userName,
                           @RequestParam("password") String password,
                           @RequestParam("rePassword") String rePassword,
                           @RequestParam("email") String email) {
        UserResult userResult = new UserResult();
        User userList = userService.queryUserByUserName(userName);
        if (userName == null) {
            userResult.setCode(2);
            userResult.setMsg("用户名不能为空");
            return userResult;
        } else {
            if (!(userList == null)) {
                userResult.setCode(3);
                userResult.setMsg("用户名已存在");
                return userResult;
            } else {
                if (!password.equals(rePassword)) {
                    userResult.setCode(4);
                    userResult.setMsg("输入的两次密码不一致");
                    return userResult;
                } else {
                    User user = new User();
                    user.setPermission(permission);
                    user.setUserName(userName);
                    user.setPassword(password);
                    user.setEmail(email);
                    if (userService.insertUser(user) > 0) {
                        userResult.setCode(1);
                        userResult.setMsg("注册成功");
                        System.out.println("注册成功！");
                        return userResult;
                    }
                    userResult.setMsg("注册失败");
                    return userResult;
                }
            }
        }
    }
}