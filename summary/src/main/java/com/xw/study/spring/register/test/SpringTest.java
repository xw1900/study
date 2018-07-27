package com.xw.study.spring.register.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xw.study.spring.register.config.MainConfig;
import com.xw.study.spring.register.config.MainConfig2;

public class SpringTest {

	
	@Test
	public void test1() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
		String[] definitionNames = context.getBeanDefinitionNames();
		for (String name : definitionNames) {
			System.out.println(name);
		}
		
		context.close();
	}
	
	@Test
	public void test2() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
		String[] definitionNames = context.getBeanDefinitionNames();
		
		for (String name : definitionNames) {
			System.out.println("--》名称:" + name + "--》类型：" + context.getType(name));
		}
		
//		System.out.println(context.getBean(Person.class).hashCode());
//		System.out.println(context.getBean(Person.class).hashCode());
		
		// 默认获取到的是工厂bean调用getObject创建的对象
		System.out.println(context.getBean("peopleFactoryBean"));
		
		// 要获取工厂Bean本身，我们需要给id前面加一个&
		System.out.println(context.getBean("&peopleFactoryBean"));

		context.close();
	}
}
