package com.xw.study.demo.oop;

//这个子类继承自父类superclass
public class SubClass extends SuperClass {
	private int subValue = 10;
	{System.out.println("代码块 " + subValue);}
	public SubClass() {
		System.out.println("构造 " + subValue);
	}
	// 这个方法重写了父类的方法
	public void setSuperValue(int x) {
		System.out.println("start subValue " + subValue);
		// 先调用父类的方法
		super.setSuperValue(x);
		// 然后把值赋给自己的变量
		subValue = x;
		System.out.println("end subValue " + subValue);
	}
	public void printSubValue() {
		System.out.println("subclass subvalue==" + subValue);
	}
    public static void main(String[] args) {
        SubClass sc=new SubClass();
        sc.printSubValue();
    }
}