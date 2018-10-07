package com.xw.study.design.principle._01openclose;

public class Test {
	// 低层次代码不能太大变，打折信息不应该直接改javaCourse，而应该改上层实现。
	public static void main(String[] args) {
		ICourse javaDiscountCourse = new JavaDiscountCourse(10, "java", 388d);
		JavaDiscountCourse javaCourse = (JavaDiscountCourse) javaDiscountCourse;
		System.out.println(javaDiscountCourse.getId() + " " + javaDiscountCourse.getName() 
			+ " " + javaDiscountCourse.getPrice() + " " + javaCourse.getDiscountPrice());
	}
}
