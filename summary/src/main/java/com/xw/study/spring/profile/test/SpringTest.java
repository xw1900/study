package com.xw.study.spring.profile.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xw.study.spring.profile.config.MainConfig4Profile;

public class SpringTest {

	@Test
	public void test01() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig4Profile.class);
		String[] names = context.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println("--》名称:" + name + "--》类型：" + context.getType(name) + "--》地址：" + context.getBean(name));
		}
		
		context.close();
	}
}
