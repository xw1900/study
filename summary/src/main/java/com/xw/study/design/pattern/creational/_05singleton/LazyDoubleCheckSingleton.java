package com.xw.study.design.pattern.creational._05singleton;

/**
 * 懒汉式 懒加载 双重锁 及 避免重排序 保证多线程安全
 * @author vincent
 *
 */
public class LazyDoubleCheckSingleton {
	private volatile static LazyDoubleCheckSingleton singleton = null;
	private LazyDoubleCheckSingleton(){}
	public static LazyDoubleCheckSingleton getInstance() {
		if (singleton == null) {
			synchronized(LazyDoubleCheckSingleton.class) {
				if (singleton == null) {
					singleton = new LazyDoubleCheckSingleton();
					// 此处new对象分为三步，1、分配内存给这个对象，
					// 2、初始化对象（即new）
					// 3、设置singleton指向刚分配的内存
// 但是由于重排序，2和3可能反过来（为什么可以反过来？因为单线程执行时这样是没问题的，所以加了volatile）
				}
			}
		}
		return singleton;
	}
}
