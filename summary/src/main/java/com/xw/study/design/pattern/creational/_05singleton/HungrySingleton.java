package com.xw.study.design.pattern.creational._05singleton;

/**
 * 饿汉式 非懒加载 多线程安全
 * @author vincent
 *
 */
public class HungrySingleton {
	private HungrySingleton(){}
	private final static HungrySingleton singleton = new HungrySingleton();
	public static HungrySingleton getInstance() {
		return singleton;
	}
}
