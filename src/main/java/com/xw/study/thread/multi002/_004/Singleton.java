package com.xw.study.thread.multi002._004;

/**
 * 用的比较多的单例模式
 * @author TTX034
 *
 */
public class Singleton {

	private Singleton(){}
	static class SingletonClass{
		static Singleton singleton = new Singleton();
	}
	public static Singleton getInstance(){
		return SingletonClass.singleton;
	}
	
	public static void main(String[] args) {
		System.out.println(Singleton.getInstance());
		System.out.println(Singleton.getInstance());
		System.out.println(Singleton.getInstance());
	}
}
