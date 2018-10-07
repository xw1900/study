package com.xw.study.design.principle._02dependenceinversion.v2;

import com.xw.study.design.principle._02dependenceinversion.AndroidCourse;
import com.xw.study.design.principle._02dependenceinversion.JavaCourse;

public class Test {
	// 此时面向抽象，要学什么，只需要将要学的具体课程传进去即可，用抽象接收。
	// 但不好的是需要在调用方法的时候将实现类传进去（即方法需要关心具体的学习课程）
		// 可以改为构造函数接收
	public static void main(String[] args) {
		Vincent vincent = new Vincent();
		vincent.study(new JavaCourse());
		vincent.study(new AndroidCourse());
	}
}
