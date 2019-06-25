package com.xw.study.tomcat.v2;

public class Bootstrap {

	public static void main(String[] args) {
		HttpConnector connector = new HttpConnector();
		connector.start();
	}
}
