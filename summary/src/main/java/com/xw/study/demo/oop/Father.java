package com.xw.study.demo.oop;

public abstract class Father {

	private int i;
	public abstract void test01();
	
	public final void method0(){
		System.out.println("father method0");
	}
	private void method1(){
		System.out.println("father method1");
	}
	public void method1(Integer i){
		System.out.println("father method1");
	}
	public static void method2(){
		System.out.println("father method2");
	}
	public void method3(){
		System.out.println("father method3");
		method0();
		method1();
		method2();
		System.out.println(i);
	}
	
//	public static void main(String[] args) {
//		Father f = new Father() {
//			@Override
//			public void test01() {
//			}
//		};
//		f.test01();
//	}
	public static void main(String[] args) {
		int i = 0;
		System.out.println(i);
	}
}
