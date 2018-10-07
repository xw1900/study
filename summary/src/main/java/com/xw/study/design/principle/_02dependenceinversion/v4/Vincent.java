package com.xw.study.design.principle._02dependenceinversion.v4;

import com.xw.study.design.principle._02dependenceinversion.ICourse;

public class Vincent {
	private ICourse course;
	public void setCourse(ICourse course) {
		this.course = course;
	}
	public void study() {
		course.studyCourse();
	}
}
