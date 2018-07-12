package com.xw.study.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.xw.study.springmvc.service.TestService;

public class BaseController {

	@Autowired
	private TestService testService;
	
	public void testService() {
		System.out.println(testService);
		testService.testPrint();
	}
}
