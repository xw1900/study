package com.xw.study.demo.serializable;

public class Father {
	private static String name = ttt();
	static {
		System.out.println("Father静态代码块" + name);
	}
	private static String age = ttt();
	{
		System.out.println("Father动态代码块");
	}
	public Father() {
		System.out.println("Father构造方法");
	}
	
	static String ttt() {
		System.out.println("ttt");
		return "ttt";
	}
}