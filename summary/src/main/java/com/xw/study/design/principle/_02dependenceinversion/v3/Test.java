package com.xw.study.design.principle._02dependenceinversion.v3;

import com.xw.study.design.principle._02dependenceinversion.JavaCourse;
import com.xw.study.design.principle._02dependenceinversion.PythonCourse;

public class Test {
	// 此时面向了抽象，也已经在构造函数中传了对应的具体实现
	// 但是，如果想要学其他的就不行了，需要新new对象，通过set改进
	public static void main(String[] args) {
		Vincent vincentJava = new Vincent(new JavaCourse());
		vincentJava.study();
		Vincent vincentPython = new Vincent(new PythonCourse());
		vincentPython.study();
	}
}
