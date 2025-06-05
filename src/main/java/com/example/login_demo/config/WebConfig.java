package com.example.login_demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.login_demo.util.LoginInterceptor;

@Configuration  // 标记为配置类
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册LoginInterceptor拦截器
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/api/**") // 拦截的路径（这里拦截所有 /api/** 请求）
                .excludePathPatterns("/api/login", "/api/register"); // 排除登录注册接口，不拦截它们
    }
}
