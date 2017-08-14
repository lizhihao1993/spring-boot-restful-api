package com.ideabook.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter {

   /*1.因为不同的服务可能会牵扯到跨域访问的问题，为了解决这个问题，我在每个服务添加了下面配置
   * 2.如果上线了，你可以把allowedOrigins的*号换成指定的域名
   * */
    @Override  
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")  
                .allowedOrigins("*")  
                .allowCredentials(true)  
                .allowedMethods("GET", "POST", "DELETE", "PUT")  
                .maxAge(3600);  
    }  

}  