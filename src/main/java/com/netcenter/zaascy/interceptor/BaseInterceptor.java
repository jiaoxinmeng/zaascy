package com.netcenter.zaascy.interceptor;

import com.netcenter.zaascy.bean.User;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/4/12.
 */
public class BaseInterceptor extends HandlerInterceptorAdapter {

    protected static final String LOGIN_URL = "/user/goLogin.do";

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("---------->拦截器在此-----------");
        HttpSession session = request.getSession(true);
        // 从session 里面获取用户名的信息
        User user = (User)session.getAttribute("user");
        // 判断如果没有取到用户信息，就跳转到登陆页面，提示用户进行登陆
        if (user == null || "".equals(user.getYonghId().toString())) {
            response.sendRedirect(LOGIN_URL);
        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
