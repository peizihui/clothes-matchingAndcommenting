package cn.clothes.controller;

import cn.clothes.dto.UserResult;
import cn.clothes.entity.User;
import cn.clothes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpContext;
import java.io.IOException;


/**
 * Created by nerd on 2016/7/1.
 */
@Controller
@RequestMapping("/user")
public class LoginController implements Filter {
    @Autowired
    private UserService userService;
    /*@Autowired
    @Qualifier("loginUserResult")
    private LoginUserResult loginUserResult;*/

    @RequestMapping(value="/login", method = RequestMethod.POST
            ,produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public UserResult login(HttpSession session, @RequestParam("userName") String userName, @RequestParam("password") String password) {
        User user = userService.queryByUserNameAndPassword(userName, password);
        //登陆过程中把用户信息放进session里面
        session.setAttribute("user", user);
        UserResult userResult = new UserResult();
        if(user != null) {
        	userResult.setUserName(user.getUserName());
        	userResult.setIcon(user.getIcon());
        	userResult.setCode(1);
        }else {
        	userResult.setCode(0);
        }
        return userResult;
     }
    
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String index() {
    	return "user/login";
    }
    
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "user/login";
    }

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}

