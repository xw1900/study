package com.xw.study.spring.properties.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value={"classpath:/springtest/person.properties"}, encoding="gbk")
public class MainConfig4Properties {

	@Value("${person.nickName}")
	String nickName;
	@Value("张三")
	String name;
	@Value("#{20-2}")
	Integer age;
	
	@Bean
	public Object test() {
		System.out.println("nickName：" + nickName + "，name：" + name + "，age：" + age);
		return new Object();
	}
}
