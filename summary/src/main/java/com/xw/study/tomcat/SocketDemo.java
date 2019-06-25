package com.xw.study.tomcat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketDemo {

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("127.0.0.1", 8080);
		OutputStream outputStream = socket.getOutputStream();
		PrintWriter out = new PrintWriter(outputStream, true);
		
		InputStream inputStream = socket.getInputStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
		
		out.println("GET /test HTTP/1.1");
		out.println("Host: localhost:8080");
		out.println("connection: Close");
		out.println();
		
		StringBuilder sb = new StringBuilder(4096);
		boolean loop = true;
		while(loop) {
			if (in.ready()) {
				int i = 0;
				while(i != -1) {
					i = in.read();
					sb.append((char)i);
				}
				loop = false;
			}
			Thread.currentThread().sleep(50);
		}
		
		System.out.println(sb.toString());
		socket.close();
		
	}
}
