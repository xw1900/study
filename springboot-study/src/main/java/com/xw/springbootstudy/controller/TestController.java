package com.xw.springbootstudy.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping("/test")
	public String test(@RequestBody String body) {
		System.out.println(body);
		return "test";
	}
	
	@RequestMapping("/test1")
	public String test1(@RequestParam String body) {
		System.out.println(body);
		return "test";
	}
}
