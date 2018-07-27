package com.xw.study.spring.other.test;

import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xw.study.spring.other.config.OtherConfig;

public class SpringTest {

	@Test
	public void test01() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(OtherConfig.class);
		String[] names = context.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println("--》名称:" + name + "--》类型：" + context.getType(name) + "--》地址：" + context.getBean(name));
		}
		
		context.publishEvent(new ApplicationEvent("test") {});
		
		context.close();
	}
}
