package com.xw.study.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xw.study.springmvc.service.TestService;

public class BaseController {

	@Autowired
	private TestService testService;
	
	public void testService() {
		System.out.println(testService);
		Long i = 1L;
		testService.testPrint(i);
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		List<BaseController> list = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			
			BaseController con = new BaseController();
			list.add(con);
			Thread.sleep(100);
		}
	}
	
//	public static void main(String[] args) {
////		String str = "计算机软件";
//		String str1 = new StringBuilder("计算机").append("软件").toString();
//		System.out.println(str1.intern() == str1);
//	}
}
