package com.xw.study.springmvc.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

@RestController
public class TestController extends BaseController {

	// @Autowired
	// private TestService testService;
	@Autowired
	private volatile Environment environment;

	@ModelAttribute
	public String index() {
		System.out.println("index");
		return "index";
	}
	
	@RequestMapping("/test2")
	public String index(@RequestBody People people) {
		System.out.println(people);
//		testService();

		return "test";
	}

	@RequestMapping("/test")
	public String index(@RequestParam(value = "name", required = false) String name,
			@RequestHeader(name = "Accept") String accept,
			@CookieValue(name = "session", required = false) String session,
			@ModelAttribute(name = "sex") String age) {
		// testService();

		System.out.println(name);
		System.out.println(accept);
		System.out.println(session);
		System.out.println(age);

		return "test";
	}

	@RequestMapping("/test1")
	public String index1(Timestamp birth) {
		System.out.println(birth);

		return "test1";
	}

	@GetMapping(value = ("/testjson/{num}"))
	public JSONObject testjson(HttpServletResponse response, @PathVariable String num)
			throws IOException, InterruptedException {
		JSONObject json = new JSONObject();
		json.put("erpId", 1);
		System.out.println("---------------" + num);

		return json;
	}

	@RequestMapping("/testresponse")
	public void testresponse(HttpServletResponse response) throws IOException {
		JSONObject json = new JSONObject();
		json.put("erpId", 1);
		response.getWriter().println(json.toJSONString());
		response.getWriter().close();
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
