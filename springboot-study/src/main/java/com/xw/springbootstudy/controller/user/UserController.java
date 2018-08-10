package com.xw.springbootstudy.controller.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value=("/test"), method=RequestMethod.GET)
	public String test() {
		return "user-test";
	}
	@RequestMapping(value=("/test"), method=RequestMethod.POST)
	public String test2() {
		return "user-test";
	}
}
