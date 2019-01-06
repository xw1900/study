package com.xw.study.design.pattern.creational._03abstractfactory;

/**
 * 课程工厂
 * @author vincent
 *
 */
public interface CourseFactory {
	Video getVideo();
	Article getArticle();
}
