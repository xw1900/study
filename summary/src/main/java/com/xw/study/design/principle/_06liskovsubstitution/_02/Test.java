package com.xw.study.design.principle._06liskovsubstitution._02;

import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		Child child = new Child();
		Map map = new HashMap<>();
		child.method(map);
	}
}
