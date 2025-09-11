package com.gec.oceanbioproject.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
@Configuration
public class GlobalCorsConfig {
    @Bean
    public CorsFilter CorsFilter() {
// 创建 CORS 配置对象
        CorsConfiguration corsConfiguration = new CorsConfiguration();
// 支持域
        corsConfiguration.addAllowedOriginPattern("*");
// 允许的原始请求头部信息
        corsConfiguration.addAllowedHeader("*");
// 支持请求方式
        corsConfiguration.addAllowedMethod("*");
// 是否发送 Cookie
        corsConfiguration.setAllowCredentials(true);
//添加地址映射
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new
                UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
//返回 CorsFilter 对象
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}
