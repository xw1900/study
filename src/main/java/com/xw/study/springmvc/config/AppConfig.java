package com.xw.study.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.xw.study.springmvc.controller.MyFirstInterceptor;

//springmvc容器只扫描Controller
//配置组件（视图解析器、视图映射、静态资源映射、拦截器。。。）
@ComponentScan(value = "com.xw.study.springmvc", useDefaultFilters = false, includeFilters = {
		@Filter(type = FilterType.ANNOTATION, classes = { Controller.class }) })
@EnableWebMvc// <mvc:annotation-driven/>
public class AppConfig extends WebMvcConfigurationSupport {

	@Override
	protected void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp();// 就是：jsp("/WEB-INF/", ".jsp");
	}
	
	// 将SpringMVC处理不了的请求交给tomcat,静态资源 就可以访问
	@Override
	protected void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	// 拦截器注册
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyFirstInterceptor()).addPathPatterns("/**");
	}
}
