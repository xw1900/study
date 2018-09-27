package com.xw.study.demo.oop;

public class Sun extends Father {
	
	public void method1(){
		System.out.println("sun method1");
	}

	public static void method2(){
		System.out.println("sun method2");
	}
	
	public static void main(String[] args) {
		Father sun = new Sun();
		sun.method3();
		
		Sun sun2 = (Sun) sun;
		sun.method3();
	}

	@Override
	public void test01() {
		People p = new People() {
		};
	}
}
