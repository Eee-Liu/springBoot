package com.ly.springBoot;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Author: LiuYi
 * @Description: Druid数据源配置
 * @Date: Created in 2018/5/14 15:12
 */
@Configuration
public class DruidConfiguration {
    //druid网页访问servlet
    @Bean
    public ServletRegistrationBean statViewServlet() {
        //创建servlet注册实体
        ServletRegistrationBean<StatViewServlet> servletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        //设置ip白名单
        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
        //设置ip黑名单,若allow跟deny共同存在时,deny优先于allow
//        servletRegistrationBean.addInitParameter("deny", "127.0.0.1");
        //设置用户
        servletRegistrationBean.addInitParameter("loginUsername", "druid");
        servletRegistrationBean.addInitParameter("loginPassword", "123456");
        //是否可以重置数据
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }


    @Bean
    public FilterRegistrationBean statFilter() {
        //创建过滤器注册实体
        FilterRegistrationBean<WebStatFilter> bean = new FilterRegistrationBean<>(new WebStatFilter());
        //设置过滤路径
        bean.addUrlPatterns("/*");
        //忽略过滤的形式
        bean.addInitParameter("exclusions", "*.js,*.jpg,*.css,/druid/*");
        return bean;
    }

    //druid监控中可以看到sql监控
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource druidDataSource(){
//        return new DruidDataSource();
//    }
}
