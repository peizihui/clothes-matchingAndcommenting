package cn.clothes.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.clothes.entity.User;

public class HandlerInterceptorFilter implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("全部拦截完毕！");
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("拦截过程处理！");
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object arg2) throws Exception {
		User user = (User) req.getSession().getAttribute("user");
        String contextPath = req.getContextPath(); 
        
		if(user != null) {
			return true;
		}else {
			resp.sendRedirect(contextPath+"/user/logout");
			return false;
		}
	}

}
