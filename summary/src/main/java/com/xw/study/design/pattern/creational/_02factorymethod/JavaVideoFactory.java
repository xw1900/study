package com.xw.study.design.pattern.creational._02factorymethod;

public class JavaVideoFactory extends VideoFactory {
	@Override
	public Video getVideo() {
		return new JavaVideo();
	}
}
