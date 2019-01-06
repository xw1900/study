package com.xw.study.design.pattern.creational._03abstractfactory;

public class JavaCourseFactory implements CourseFactory {
	@Override
	public Video getVideo() {
		return new JavaVideo();
	}
	@Override
	public Article getArticle() {
		return new JavaArticle();
	}
}
