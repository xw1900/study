package com.xw.study.design.pattern.creational._01simplefactory;

public class Test {
	public static void main(String[] args) {
		Video video = VideoFactory.getVideo(PythonVideo.class);
		if (null == video) {
			return;
		}
		video.play();
	}
}
