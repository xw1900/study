package com.xw.study.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {

	@Autowired
	private HelloService helloService;
	
	public void test() {
		System.out.println(helloService);
	}
}
