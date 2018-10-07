package com.xw.study.design.principle._06liskovsubstitution._01;

import java.util.HashMap;
import java.util.Map;

public class Child extends Father {
	@Override
	public void method(HashMap map) {
		System.out.println("子类的method执行HashMap");
	}
	public void method(Map map) {
		System.out.println("子类的method执行Map");
	}
}
