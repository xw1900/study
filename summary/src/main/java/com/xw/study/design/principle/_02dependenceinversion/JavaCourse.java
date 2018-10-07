package com.xw.study.design.principle._02dependenceinversion;

public class JavaCourse implements ICourse {
	@Override
	public void studyCourse() {
		System.out.println("学习java课程");
	}
}
