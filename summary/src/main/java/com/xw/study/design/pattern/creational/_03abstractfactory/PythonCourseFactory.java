package com.xw.study.design.pattern.creational._03abstractfactory;

public class PythonCourseFactory implements CourseFactory{
	@Override
	public Video getVideo() {
		return new PythonVideo();
	}
	@Override
	public Article getArticle() {
		return new PythonArticle();
	}
}
