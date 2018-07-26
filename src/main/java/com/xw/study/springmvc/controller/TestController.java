package com.xw.study.springmvc.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController extends BaseController {

//	@Autowired
//	private TestService testService;
	@Autowired
	private Environment environment;
	
	@RequestMapping("/test2")
	public String index(@RequestBody People people) {
		System.out.println(people);
		testService();
		
		return "test";
	}
	
	@RequestMapping("/test")
	public String index() {
		testService();
		
		return "test";
	}
	
	@RequestMapping("/test1")
	public String index1(Timestamp time) {
		System.out.println(time);
		
		return "test1";
	}
	
	@RequestMapping("/testresponse")
	public void testresponse(HttpServletResponse response) throws IOException {
		response.getWriter().println("www.baidu.com");
		response.getWriter().close();
//		return "test";
	}
	
	@RequestMapping("/testpeople")
	public People testpeople() {
		People p = new People();
		p.setBirth(new Timestamp(System.currentTimeMillis()));
		String property = environment.getProperty("redis.host");
		System.out.println(property);
		return p;
	}
}
