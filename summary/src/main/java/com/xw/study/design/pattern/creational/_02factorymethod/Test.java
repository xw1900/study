package com.xw.study.design.pattern.creational._02factorymethod;

public class Test {
	public static void main(String[] args) {
		VideoFactory videoFactory = new JavaVideoFactory();
		Video video = videoFactory.getVideo();
		if (null == video) {
			return;
		}
		video.play();
	}
}
