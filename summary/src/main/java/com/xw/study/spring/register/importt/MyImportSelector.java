package com.xw.study.spring.register.importt;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义逻辑需要注册到容器中的组件
 *
 */
public class MyImportSelector implements ImportSelector {

	/**
	 * 返回值就是要注册到容器中的组件的全类名称
	 * importingClassMetadata 当前标注@Import注解的类的所有的注解信息，谁标注了就是谁的信息
	 */
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		
		return new String[]{"com.xw.study.spring.bean.Yellow", "com.xw.study.spring.bean.RainBow"};
	}

}
