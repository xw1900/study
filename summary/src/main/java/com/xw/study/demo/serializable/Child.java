package com.xw.study.demo.serializable;

public class Child extends Father {
	static {
		System.out.println("Child静态代码块！");
	}
	{
		System.out.println("Child动态代码块");
	}
	public Child() {
		System.out.println("Child构造方法");
	}
	public static void main(String[] args) {
		System.out.println("main方法开始！！！！！！！！！！！！！");
		Child child = new Child();
		System.out.println("第二次初始化----------");
		Child child2 = new Child();
	}
}