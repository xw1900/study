package com.xw.study.spring.register.importt;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.xw.study.spring.register.bean.RainBow;

/**
 * 根据目前已知的条件（如容器中是否有某个容器）注册自己想要注册的bean
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	/**
	 * importingClassMetadata 当前 标注了@Import的类的注解信息
	 * registry 
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		boolean definition = registry.containsBeanDefinition("bill");
		if (definition) {
			BeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
			registry.registerBeanDefinition("rainBow", beanDefinition );
		}
	}

}
