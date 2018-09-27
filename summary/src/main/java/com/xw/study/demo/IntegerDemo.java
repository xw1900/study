package com.xw.study.demo;

import java.util.Arrays;

public class IntegerDemo {

	public static void main(String[] args) {
		String str = "11,12,";
		String[] split = str.split(",");
		System.out.println(split.length);
		for (String string : split) {
			System.out.println(string);
		}
	}
}
