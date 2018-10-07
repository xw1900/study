package com.xw.study.design.principle._05demeter.v2;

import java.util.ArrayList;
import java.util.List;

public class TeamLeader {
	public void checkNumbers() {
		List<Course> courses = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			courses.add(new Course());
		}
		System.out.println("课程数量为：" + courses.size());
	}
}
