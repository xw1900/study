package com.xw.study.tomcat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

	private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
	
	private boolean shutdown = false;
	
	public static void main(String[] args) {
		HttpServer server = new HttpServer();
		server.await();
	}

	private void await() {
		ServerSocket serverSocket = null;
		int port = 8080;
		
		try {
			serverSocket = new ServerSocket(port, 5, InetAddress.getByName("127.0.0.1"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		while(!shutdown) {
			try {
				Socket socket = serverSocket.accept();
				OutputStream outputStream = socket.getOutputStream();
				InputStream inputStream = socket.getInputStream();
				
				
				
				Request request = new Request(inputStream);
				request.parse();
				
				Response response = new Response(outputStream);
				response.setRequest(request);
				
				if (request.getUrl().startsWith("/servlet/")) {
					ServletProcess processor = new ServletProcess();
					processor.process(request, response);
				} else {
					StaticResourceProcessor processor = new StaticResourceProcessor();
					processor.process(request, response);
				}
				
				socket.close();
				
				shutdown = SHUTDOWN_COMMAND.equals(request.getUrl());
				
			} catch (IOException e) {
				e.printStackTrace();
				continue;
			}
		}
		
	}
}
