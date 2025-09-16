package com.gec.oceanbioproject.config;

import com.gec.oceanbioproject.interceptor.Durationinterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {
    @Autowired
    Durationinterceptor durationinterceptor;
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(durationinterceptor)
                .addPathPatterns("/**");
    }
}
