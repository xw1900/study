package com.xw.study.spring.lifecycle.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xw.study.spring.lifecycle.config.MainConfig4LiftCycle;

public class SpringTest {

	@Test
	public void test01() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig4LiftCycle.class);
		String[] names = context.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println("--》名称:" + name + "--》类型：" + context.getType(name));
		}
	}
}
