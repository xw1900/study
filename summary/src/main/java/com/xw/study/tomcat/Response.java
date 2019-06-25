package com.xw.study.tomcat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;

public class Response implements ServletResponse {

	private Request request;
	
	public void setRequest(Request request) {
		this.request = request;
	}
	
	private OutputStream outputStream;
	
	public Response(OutputStream outputStream) {
		this.outputStream = outputStream;
	}

	public void sendStaticResource() throws IOException {
		FileInputStream fis = null;
		try {
			File file = new File(Constant.WEB_ROOT, request.getUrl());
			
			if (file.exists()) {
				fis = new FileInputStream(file);
				byte[] bytes = new byte[1024];
				int ch = fis.read(bytes);
				while(ch != -1) {
					outputStream.write(bytes, 0, ch);
					ch = fis.read(bytes);
				}
			} else {
				String errorMessage = "HTTP/1.1 404 File Not Fount\r\n" + 
						"Content-Type: text/html\r\n" + 
						"Content-Length: 23\r\n" + 
						"\r\n" + 
						"<h1>File Not Found</h1>";
				outputStream.write(errorMessage.getBytes());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
//			if (null != outputStream) {
//				try {
//					outputStream.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
			if (null != fis) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public String getCharacterEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		return null;
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		PrintWriter writer = new PrintWriter(outputStream, true);
		return writer;
	}

	@Override
	public void setCharacterEncoding(String charset) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setContentLength(int len) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setContentType(String type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBufferSize(int size) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getBufferSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void flushBuffer() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetBuffer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isCommitted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLocale(Locale loc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}

}
