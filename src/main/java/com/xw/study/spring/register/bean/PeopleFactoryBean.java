package com.xw.study.spring.register.bean;

import org.springframework.beans.factory.FactoryBean;

public class PeopleFactoryBean implements FactoryBean<Person> {

	/**
	 * 实例化一个对象，添加到容器中
	 */
	@Override
	public Person getObject() throws Exception {
		return new Person();
	}

	/**
	 * 注册到容器中的bean的类型
	 */
	@Override
	public Class<?> getObjectType() {
		return Person.class;
	}

	/**
	 * 是否是单例
	 */
	@Override
	public boolean isSingleton() {
		return true;
	}

}
