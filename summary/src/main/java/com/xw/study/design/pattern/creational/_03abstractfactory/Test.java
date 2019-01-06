package com.xw.study.design.pattern.creational._03abstractfactory;

public class Test {

	public static void main(String[] args) {
//		CourseFactory courseFactory = new JavaCourseFactory();
		
		CourseFactory courseFactory = new PythonCourseFactory();
		
		Article article = courseFactory.getArticle();
		Video video = courseFactory.getVideo();
		video.play();
		article.play();
	}
}
