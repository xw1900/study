package com.xw.study.springmvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// web容器启动的时候创建对象，调用方法来初始化根容器以及前端控制器
public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	// 获取根容器的配置类。spring的配置类。父容器
	@Override
	protected Class<?>[] getRootConfigClasses() {
//		return new Class<?>[]{RootConfig.class};
		return null;
	}

	// 获取web容器的配置类。springmvc的配置类。子容器
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{AppConfig.class};
	}

	/**
	 * DispatherServlet的映射信息
	 *	/:拦截所有的请求，包括静态资源，但是不包括.jsp文件
	 *	/*:拦截所有请求，包括静态资源，同时包括jsp文件
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

}
