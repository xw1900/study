package com.xw.study.spring.profile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Profile：根据当前环境（test,dev,pre,pro），动态的切换和激活一系列组件的功能
 * 如：test dev pre 数据库不一样
 * 		激活profile：给当前上下文传递参数
 * 			-Dspring.profiles.active=test
 */
@Configuration
public class MainConfig4Profile {

	@Profile(value={"test"})
	@Bean
	public Object object01() {
		System.out.println("object01");
		return new Object();
	}
	
	@Profile(value={"dev"})
	@Bean
	public Object object02() {
		System.out.println("object02");
		return new Object();
	}
	
	@Profile(value={"pre"})
	@Bean
	public Object object03() {
		System.out.println("object03");
		return new Object();
	}
}
