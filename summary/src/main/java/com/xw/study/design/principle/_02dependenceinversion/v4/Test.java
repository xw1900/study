package com.xw.study.design.principle._02dependenceinversion.v4;

import com.xw.study.design.principle._02dependenceinversion.JavaCourse;
import com.xw.study.design.principle._02dependenceinversion.PythonCourse;

public class Test {
	// 此时想要学什么直接设置要学的课程即可。
	public static void main(String[] args) {
		Vincent vincent = new Vincent();
		vincent.setCourse(new JavaCourse());
		vincent.study();
		vincent.setCourse(new PythonCourse());
		vincent.study();
	}
}
