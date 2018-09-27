package com.xw.study.demo.serializable;

public class Father {
	private static String name;
	static {
		System.out.println("Father静态代码块");
	}
	{
		System.out.println("Father动态代码块");
	}
	public Father() {
		System.out.println("Father构造方法");
	}
}