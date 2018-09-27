package com.xw.study.demo.serializable;
class Father2{
    int m = 0;
    public void set() {
        m += 1;
    }
    public Father2() {
        set();
    }
}
public class Son extends Father2{
	int m = 10;
	public void set() {
        m += 3;
    }
    public static void main(String[] args) {
    	Son f = new Son();
        System.out.println(f.m);
    }
}