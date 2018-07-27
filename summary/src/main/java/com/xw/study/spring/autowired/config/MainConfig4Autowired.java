package com.xw.study.spring.autowired.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.xw.study.spring.autowired.service.TestService;

/**
 * 自动装配：
 *	1、@Autowired：自动注入
 *		1、默认先按照类型去容器中找对应的的组件，byType
 *		2、如果找到多个相同type的组件，再根据名称（即将属性的名称作为组件的id）去找，byName
 *		3、默认是如果找不到就报错，可设置@Autowired(required=false)
 *		4、@Primary，如果有多个，可设置首选的bean
 *		5、@Qualifier(value="")，（会覆盖@Primary的设置），指定要使用的组件的id，而不是属性名
 *	2、@Resource：按照名称来注入
 *		没有支持(required=false)和@Primary
 *
 *	@Autowired原理：AutowiredAnnotationBeanPostProcessor
 *		
 *	3、@Autowired位置：
 *		1、方法上，public Object test(TestService testService)
 *			会自动注入，默认不写@Autowired效果是一样的，都能自动装配
 *		2、构造方法上，
 *		3、常规操作：放到参数位置
 *		
 *	4、自定义组件想要使用spring底层组件的组件（ApplicationContext）
 *		自定义组件实现xxxAware，创建对象的时候回注入相关组件；Aware
 *		xxxAware：功能实现：xxxAwareProcessor
 *			ApplicationContextAware-->ApplicationContextAwareProcessor
 */
@Configuration
@ComponentScan(value={"com.xw.study.spring.autowired.service"})
public class MainConfig4Autowired {

//	@Autowired// (required=false)
//	@Qualifier(value="testServiceImpl")
//	private TestService testService;
	
//	@Resource
//	private TestService testService;
	
	@Bean
	public Object test(@Autowired TestService testService) {
		System.out.println("test---> " + testService);
		return new Object();
	}
}
