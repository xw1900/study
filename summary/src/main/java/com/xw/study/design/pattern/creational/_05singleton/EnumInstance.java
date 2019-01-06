package com.xw.study.design.pattern.creational._05singleton;

public enum EnumInstance {
	INSTANCE,
	;
	public static Object getInstance() {
		return INSTANCE;
	}
}
