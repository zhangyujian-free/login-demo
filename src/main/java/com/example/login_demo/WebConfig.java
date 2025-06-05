package com.example.login_demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
