package com.xw.study.design.pattern.creational._02factorymethod;

public class PythonVideoFactory extends VideoFactory {
	@Override
	public Video getVideo() {
		return new PythonVideo();
	}
}
