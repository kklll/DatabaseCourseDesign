package com.deep.dbdesign.config;

import com.deep.dbdesign.interceptor.ManagerInterceptor;
import com.deep.dbdesign.interceptor.StudentInterceptor;
import com.deep.dbdesign.interceptor.TeacherInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ManagerInterceptor()).addPathPatterns("/managers/**");
        registry.addInterceptor(new StudentInterceptor()).addPathPatterns("/student/**");
        registry.addInterceptor(new TeacherInterceptor()).addPathPatterns("/teacher/**");
    }

    @Override
    //静态资源
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
