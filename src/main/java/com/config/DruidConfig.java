package com.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.sql.DataSource;
import java.util.HashMap;

/**
 *  访问页面：xxx/druid/login.html
 */
@Configuration
public class DruidConfig {


    @Bean
    // 将所有前缀为spring.datasource下的配置项都加载DataSource中
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }


    //后台监控
    @Bean
    public ServletRegistrationBean<Servlet> druidServlet() {
        // 进行 druid 监控的配置处理
        ServletRegistrationBean<Servlet> srb = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        HashMap<String,String> map = new HashMap<>();
//        map.put("loginUsername","root");
//        map.put("loginPassword","11");
//        map.put("allow", "");
//        map.put("deny", "192.168.31.253");
//        srb.setInitParameters(map);

        // 白名单 允许谁都可以访问 ，第二个参数，一般指具体的 人
        srb.addInitParameter("allow", "");
        // 黑名单 禁止别人访问
        srb.addInitParameter("deny", "192.168.31.253");
        // 用户名
        srb.addInitParameter("loginUsername", "root");
        // 密码
        srb.addInitParameter("loginPassword", "root");
        // 是否可以重置数据源
        srb.addInitParameter("resetEnable", "false");
        return srb;
    }

    // filter 过滤
    @Bean
    public FilterRegistrationBean<Filter> filterRegistrationBean() {
        FilterRegistrationBean<Filter> frb = new FilterRegistrationBean<>();
        frb.setFilter(new WebStatFilter());
        // 所有请求进行监控处理
        frb.addUrlPatterns("/*");
        // 排除名单
        frb.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.css,/druid/*");
        return frb;
    }

}



