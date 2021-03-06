package com.xw.study.spring.lifecycle.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Component
public class Car {
	
	public Car(){
		System.out.println("car constructor...");
	}
	
	@PostConstruct
	public void init(){
		System.out.println("car ... init...");
	}
	
	@PreDestroy
	public void detory(){
		System.out.println("car ... detory...");
	}
	
	
//	@Bean
//	public Person person() {
//		return new Person();
//	}

}