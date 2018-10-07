package com.xw.study.design.principle._01openclose;

/**
 * java课程打折
 * @author vincent
 *
 */
public class JavaDiscountCourse extends JavaCourse {
	public JavaDiscountCourse(Integer id, String name, Double price) {
		super(id, name, price);
	}
	public Double getDiscountPrice() {
		return super.getPrice() * 0.8;
	}
}
