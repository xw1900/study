package com.xw.study.design.principle._06liskovsubstitution._01;

import java.util.HashMap;

public class Father {
	public void method(HashMap map) {
		System.out.println("父类的method执行HashMap");
	}
}
