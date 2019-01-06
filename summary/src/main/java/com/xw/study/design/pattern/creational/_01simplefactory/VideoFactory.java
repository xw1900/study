package com.xw.study.design.pattern.creational._01simplefactory;

public class VideoFactory {
//	public static Video getVideo(String type) {
//		if ("java".equalsIgnoreCase(type)) {
//			return new JavaVideo();
//		} else if ("python".equalsIgnoreCase(type)) {
//			return new PythonVideo();
//		} else {
//			return null;
//		}
//	}
	public static Video getVideo(Class clazz) {
		Video video = null;
		try {
			video = (Video) clazz.forName(clazz.getName()).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return video;
	}
}
