package com.gec.oceanbioproject.filter;

import org.springframework.stereotype.Component;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class DurationFilter implements Filter {
    private static final Logger LOG = LoggerFactory.getLogger(DurationFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 打印请求信息
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        LOG.info("------------- LogFilter 开始 -------------");
        LOG.info("请求地址: {} {}", request.getRequestURL().toString(),
                request.getMethod());
        LOG.info("远程地址: {}", request.getRemoteAddr());
        long startTime = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        LOG.info("------------- LogFilter 结束 耗时：{} ms -------------",
                System.currentTimeMillis() - startTime);
    }
}
