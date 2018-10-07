package com.xw.study.design.principle._02dependenceinversion.v1;

public class Test {
	// 此时，上层依赖于底层实现，底层新学一个课程，需要改代码。
	// 此时是面向实现编程，没有面向抽象
	public static void main(String[] args) {
		Vincent vincent = new Vincent();
		vincent.studyJavaCourse();
		vincent.studyAndroidCourse();
		vincent.studyPythonCourse();
	}
}
