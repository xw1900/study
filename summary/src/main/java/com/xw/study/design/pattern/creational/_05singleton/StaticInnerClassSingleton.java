package com.xw.study.design.pattern.creational._05singleton;

import java.io.Serializable;

/**
 * 懒加载 静态内部类保证多线程安全
 * @author vincent
 *
 */
public class StaticInnerClassSingleton implements Serializable {
	private StaticInnerClassSingleton(){
		if (Singleton.singleton != null)
		throw new RuntimeException("弄啥呢？");
	}
	private static class Singleton {
		private static StaticInnerClassSingleton singleton = new StaticInnerClassSingleton();
	}
	public static StaticInnerClassSingleton getInstance(){
		return Singleton.singleton;
	}
}
