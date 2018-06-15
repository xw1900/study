package com.xw.study.spring.autowired.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.xw.study.spring.autowired.service.TestService;

@Configuration
@ComponentScan(value={"com.xw.study.spring.autowired.service"})
public class MainConfig4Autowired {

	@Autowired
	@Qualifier(value="testServiceImpl")
	private TestService testService;
	
	@Bean
	public Object test() {
		System.out.println("test---> " + testService);
		return new Object();
	}
}
