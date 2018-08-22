package com.xw.study.nio.base;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Server implements Runnable{
	
	private Selector selector;
	
	public Server(int port) {
		try {
			// 打开多路复用器
			this.selector = Selector.open();
			// 打开服务器通道
			ServerSocketChannel ssc = ServerSocketChannel.open();
			// 设置服务器通道为非阻塞模式
			ssc.configureBlocking(false);
			// 绑定地址及端口
			ssc.bind(new InetSocketAddress(port));
			// 注册到多路复用器上监听连接事件，reactor模型中
			ssc.register(selector, SelectionKey.OP_ACCEPT);
			
			System.out.println("Server start, port :" + port + " " + ssc.hashCode());
			
			// 让多路复用器开始监听，没有则会阻塞
			selector.select();
			Set<SelectionKey> selectedKeys = selector.selectedKeys();
			Iterator<SelectionKey> iterator = selectedKeys.iterator();
			while(iterator.hasNext()) {
				SelectionKey selectionKey = iterator.next();
				if(selectionKey.isValid()){
					// 监听的是连接事件
					if (selectionKey.isAcceptable()) {
						accept(selectionKey);
					}
					// 监听的是可读事件
					if (selectionKey.isReadable()) {
						read(selectionKey);
					}
					// 监听的是可写事件
					if (selectionKey.isWritable()) {
						write();
					}
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void write() {
		// TODO Auto-generated method stub
		
	}

	private void read(SelectionKey selectionKey) {
		// TODO Auto-generated method stub
		
	}

	private void accept(SelectionKey selectionKey) {
		ServerSocketChannel ssc = (ServerSocketChannel) selectionKey.channel();
		try {
			System.out.println("ssc " + ssc.hashCode());

			SocketChannel sc = ssc.accept();
			System.out.println("sc " + sc.hashCode());
			sc.configureBlocking(false);
			sc.register(selector, SelectionKey.OP_READ);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		
		
	}
	
	public static void main(String[] args) {
		new Server(8765);
	}
}
