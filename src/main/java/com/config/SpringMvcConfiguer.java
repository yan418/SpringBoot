package com.config;

import com.config.component.LocaleResoverLanguage;
import com.config.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *  WebMvcConfigurer
 */
@Configuration
public class SpringMvcConfiguer implements WebMvcConfigurer{

    /** 默认显示首页 */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home/index");
        registry.addViewController("/index.html").setViewName("home/index");
        registry.addViewController("/index").setViewName("home/index");
    }


    /** 拦截器   */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/index","/index.html","/doLogin")
                .excludePathPatterns("/asserts/**");
    }


    /* 区域解析器  国际化多语 */
    @Bean
    public LocaleResolver localeResolver(){
        return new LocaleResoverLanguage();
    }



}
