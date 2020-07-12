package com.config.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  拦截器
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    // 拦截前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object loginState = request.getSession().getAttribute("LoginState");
        if(loginState != null){
            return true;
        }
        request.setAttribute("loginMsg","你没有权限，请登录");
        //转发
        request.getRequestDispatcher("/index").forward(request,response);
        return false;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
