package com.xw.study.spring.aop.bean;

public class MathCalculator {

	public int div(int i, int j) throws Exception {
		System.out.println("MathCalculator...div...");
		return i / j;
	}

}