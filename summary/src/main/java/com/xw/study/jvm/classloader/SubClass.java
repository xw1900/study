package com.xw.study.jvm.classloader;

public class SubClass extends SuperClass {
	static {
		System.out.println("SubClass static");
	}
}
