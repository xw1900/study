package com.xw.study.spring.register.filterType;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public class MyCustomFilterType implements TypeFilter {

	/**
	 * paramMetadataReader 获取到 当前正在扫描 的类的信息 paramMetadataReaderFactory 获取到 其他任何类
	 * 的信息
	 * 
	 */
	@Override
	public boolean match(MetadataReader paramMetadataReader, MetadataReaderFactory paramMetadataReaderFactory)
			throws IOException {

		// 获取当前正在扫描的的类注解的信息
		AnnotationMetadata annotationMetadata = paramMetadataReader.getAnnotationMetadata();
		// 获取当前正在扫描的类的类信息
		ClassMetadata classMetadata = paramMetadataReader.getClassMetadata();
		// 获取到当前正在扫描的类的信息
		Class<? extends MetadataReader> class1 = paramMetadataReader.getClass();
		// 获取当前正在扫描的类的资源（类的路径）
		Resource resource = paramMetadataReader.getResource();

//		System.out.println("---MyCustomFilterType--" + classMetadata.getClassName());
//		System.out.println("---MyCustomFilterType--" + classMetadata);
//		System.out.println("---MyCustomFilterType--" + class1);
//		System.out.println("---MyCustomFilterType--" + resource);

		String className = classMetadata.getClassName();
		if (className.contains("controller")) {
			return true;
		}
		return false;
	}

}
