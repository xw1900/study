package com.xw.study.tomcat;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

public class ServletProcess {

	public void process(Request request, Response response) {
		
		URLClassLoader urlClassLoader = null;
		String servletName = null;
		try {
			String url = request.getUrl();
			servletName = url.substring(url.lastIndexOf("/") + 1);
			
			File classPath = new File(Constant.WEB_ROOT);
			URL[] urls = new URL[1];
			String spec;
		
			spec = new URL("file", null, classPath.getCanonicalPath() + File.separator).toString();
			
			URLStreamHandler handler = null;
			urls[0] = new URL(null, spec , handler);
			urlClassLoader = new URLClassLoader(urls );
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Class loadClass = null;
		try {
			loadClass = urlClassLoader.loadClass(servletName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Servlet servlet = null;
		try {
			servlet = (Servlet)loadClass.newInstance();
			
			servlet.service(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
