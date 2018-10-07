package com.xw.study.design.principle._06liskovsubstitution._02;

import java.util.HashMap;
import java.util.Map;

public class Child extends Father {
	@Override
	public void method(Map map) {
		System.out.println("子类的method执行Map");
	}
	public void method(HashMap map) {
		System.out.println("子类的method执行HashMap");
	}
}
