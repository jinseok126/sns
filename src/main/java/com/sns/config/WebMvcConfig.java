package com.sns.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sns.interceptor.AdminSessionInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(new AdminSessionInterceptor()).addPathPatterns("admin/**").addPathPatterns("/admin/")
		.excludePathPatterns("/admin/login*");
	}
}
