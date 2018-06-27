package com.ly.springBoot.congif;

import com.ly.springBoot.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: LiuYi
 * @Description: 拦截器配置
 * @Date: Created in 2018/5/19 15:42
 */
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor())
                .addPathPatterns("/**") //拦截路径
                .excludePathPatterns("/js/**", "/**/error", "/css/**", "/auth/login.do", "/auth/login.view");//过滤路径
    }
}