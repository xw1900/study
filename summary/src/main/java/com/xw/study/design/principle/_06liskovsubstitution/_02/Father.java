package com.xw.study.design.principle._06liskovsubstitution._02;

import java.util.Map;

public class Father {
	public void method(Map map) {
		System.out.println("父类的method执行Map");
	}
}
