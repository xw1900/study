package com.xw.study.spring.properties.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xw.study.spring.properties.config.MainConfig4Properties;

public class Springtest {

	@Test
	public void test01() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig4Properties.class);
		String[] names = context.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println("--》名称:" + name + "--》类型：" + context.getType(name));
		}
		
		context.close();
	}
}
