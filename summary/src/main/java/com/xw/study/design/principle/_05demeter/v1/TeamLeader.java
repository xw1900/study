package com.xw.study.design.principle._05demeter.v1;

import java.util.List;

public class TeamLeader {
	public void checkNumbers(List<Course> courses) {
		System.out.println("课程数量为：" + courses.size());
	}
}
