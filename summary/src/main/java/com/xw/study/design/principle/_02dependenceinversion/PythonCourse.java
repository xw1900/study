package com.xw.study.design.principle._02dependenceinversion;

public class PythonCourse implements ICourse {
	@Override
	public void studyCourse() {
		System.out.println("学习Python课程");
	}
}
