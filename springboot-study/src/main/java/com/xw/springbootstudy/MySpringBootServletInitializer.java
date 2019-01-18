package com.xw.springbootstudy;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 打成war包启动，servlet3.0后特性才支持（以及META-INF/services（spring-web下有）下的源数据）。
 * jar启动时，虽然嵌入式的容器也是在refresh中启动的，但是这个特性是失效的。
 * 		（因为此时tomcat不是自己启动的，而是spring调用内嵌tomcat的start方法启动的）
 */
public class MySpringBootServletInitializer extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		
		System.out.println("------------------------hhhhh-----------------------");
		return builder.sources(SpringbootApplication.class);
	}
}