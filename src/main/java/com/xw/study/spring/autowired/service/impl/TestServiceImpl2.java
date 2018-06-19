package com.xw.study.spring.autowired.service.impl;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.xw.study.spring.autowired.service.TestService;

@Primary
@Service
public class TestServiceImpl2 implements TestService, ApplicationContextAware {

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TestServiceImpl2 org.springframework.context.annotation.AnnotationConfigApplicationContext
		System.out.println("TestServiceImpl2 " + applicationContext);
	}

}
