package com.xw.study.springmvc.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xw.study.springmvc.service.TestService;

@RestController
public class TestController extends BaseController {

//	@Autowired
//	private TestService testService;
	
	@RequestMapping("/test")
	public String index(@RequestBody People people) {
		System.out.println(people);
		testService();
		
		return "test";
	}
	
	@RequestMapping("/test1")
	public String index1(Timestamp time) {
		System.out.println(time);
		
		return "test1";
	}
}
