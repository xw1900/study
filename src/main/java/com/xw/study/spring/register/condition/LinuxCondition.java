package com.xw.study.spring.register.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 根据条件来判断是否加载bean到容器
 *
 */
public class LinuxCondition implements Condition {

	/**
	 * context 判断条件当前可以使用的上下文信息
	 * metadata 注释信息
	 */
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

		// 获取到ioc使用的BeanFactory
		context.getBeanFactory();
		// 获取到类加载器
		context.getClassLoader();
		// 获取到当前环境信息
		Environment environment = context.getEnvironment();
		// 获取到bean定义的注册类
		context.getRegistry();
		
		String osName = environment.getProperty("os.name");
		if (osName.contains("linux")) {
			return true;
		}
		return false;
	}

}
