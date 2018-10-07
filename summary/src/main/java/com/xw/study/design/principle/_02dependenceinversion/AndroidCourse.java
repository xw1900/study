package com.xw.study.design.principle._02dependenceinversion;

public class AndroidCourse implements ICourse {
	@Override
	public void studyCourse() {
		System.out.println("学习Android课程");
	}
}
