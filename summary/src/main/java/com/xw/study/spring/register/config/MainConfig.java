package com.xw.study.spring.register.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.xw.study.spring.register.bean.Person;
import com.xw.study.spring.register.filterType.MyCustomFilterType;

/**
 * @ComponentScan  value:指定要扫描的包，默认的规则会将@Component及其子类保存。
 * excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除那些组件
 * includeFilters = Filter[] ：指定扫描的时候只需要包含哪些组件
 * FilterType.ANNOTATION：按照注解
 * FilterType.ASSIGNABLE_TYPE：按照给定的类型；
 * FilterType.ASPECTJ：使用ASPECTJ表达式
 * FilterType.REGEX：使用正则指定
 * FilterType.CUSTOM：使用自定义规则
 */
@Configuration
@ComponentScan(value = { "com.xw.study.spring" }, useDefaultFilters = false, includeFilters = {
//		@Filter(type = FilterType.ANNOTATION, value = Controller.class) 
//		@Filter(type = FilterType.ASSIGNABLE_TYPE, value = TestController.class) 
		@Filter(type = FilterType.CUSTOM, value = MyCustomFilterType.class) 
})
public class MainConfig {

	@Bean
	public Person person01() {
		return new Person("hahahaha", 18);
	}
}
