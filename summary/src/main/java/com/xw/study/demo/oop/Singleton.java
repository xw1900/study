package com.xw.study.demo.oop;

public class Singleton {

	private Singleton(){}
	
	private static class SingletonInstance{
		public static Singleton singleton = new Singleton();
	}
	
	public static Singleton getInstance(){
		return SingletonInstance.singleton;
	}
	
	public static void main(String[] args) {
		Singleton singleton = Singleton.getInstance();
		System.out.println(singleton);
	}
}
