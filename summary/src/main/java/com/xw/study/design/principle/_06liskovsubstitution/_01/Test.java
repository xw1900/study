package com.xw.study.design.principle._06liskovsubstitution._01;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		Child child = new Child();
		HashMap map = new HashMap<>();
		child.method(map);
	}
}
