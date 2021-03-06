package com.xw.study.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;

import com.xw.study.springmvc.controller.MyFirstInterceptor;

//springmvc容器只扫描Controller
//配置组件（视图解析器、视图映射、静态资源映射、拦截器。。。）
@ComponentScan(value = "com.xw.study.springmvc"/*, useDefaultFilters = false, includeFilters = {
		@Filter(type = FilterType.ANNOTATION, classes = { Controller.class }) }*/)
//@EnableWebMvc// <mvc:annotation-driven/>
@Configuration// 此处的@Configuration 可不写，代码中本来就会把这个类当做配置类
@EnableAspectJAutoProxy
@PropertySources({ @PropertySource("classpath:properties/redis.properties") })
public class AppConfig extends DelegatingWebMvcConfiguration {

	@Override
	protected void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp();// 就是：jsp("/WEB-INF/", ".jsp");
	}
	
	// 将SpringMVC处理不了的请求交给tomcat,静态资源 就可以访问
	@Override
	protected void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Override
	protected void addFormatters(FormatterRegistry registry) {
		TimestampConverter timestampConverter = new TimestampConverter();
		registry.addConverter(timestampConverter);
	}
	
	
	// 测试cherry-pick
	
	// 拦截器注册
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyFirstInterceptor()).addPathPatterns("/**");
	}
}
