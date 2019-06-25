package com.xw.study.jvm.classloader;

public class ConstClass {
	static {
		System.out.println("ConstClass static");
	}
	public static final String HELLO="HELLO";
}
