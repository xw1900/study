package com.xw.study.design.principle._05demeter.v1;

import java.util.ArrayList;
import java.util.List;

public class Boss {
	public void commandCheckNumbers(TeamLeader teamLeader){
		List<Course> courses = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			courses.add(new Course());
		}
		teamLeader.checkNumbers(courses);
	}
}
