package com.xw.springbootstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.xw.springbootstudy.controller.user")
public class SpringbootApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringbootApplication.class, args);
	}
}
