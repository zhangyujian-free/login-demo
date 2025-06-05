package com.example.login_demo.util;

import org.springframework.web.servlet.HandlerInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {

        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("loggedInUser") != null) {
            return true; // 登录过，放行
        }

        response.setContentType("text/plain;charset=UTF-8"); // 避免中文乱码
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("未登录，禁止访问");
        return false; // 拦截请求
    }
}
