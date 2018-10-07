package com.xw.study.design.principle._02dependenceinversion.v2;

import com.xw.study.design.principle._02dependenceinversion.ICourse;

public class Vincent {
	public void study(ICourse iCourse) {
		iCourse.studyCourse();
	}
}
