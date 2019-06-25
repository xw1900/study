package com.xw.study.jvm.classloader;

public class SuperClass {
	public static int value = 22;
	static {
		System.out.println("superClass static");
	}
}
