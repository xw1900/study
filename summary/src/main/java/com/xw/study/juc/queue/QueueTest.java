package com.xw.study.juc.queue;

import java.util.concurrent.LinkedBlockingQueue;

public class QueueTest {

	static LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>(1000);

	public static void main(String[] args) throws InterruptedException {
//		testLinkedBlockingQueue();
		
		Thread putThread = new Thread(){
			public void run() {
				try {
					for(int i = 0;i<100;i++) {
						queue.put(i + "");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
		};
		
		Thread takeThread = new Thread(){
			public void run() {
				try {
					while(true) {
						String str = queue.take();
						Thread.sleep(1000);
						System.out.println(str);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
		};
		
		putThread.start();
		takeThread.start();
		
		Thread.sleep(100000000);
		
	}

	private static void testLinkedBlockingQueue() {
		LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>(1);
		System.out.println(queue.offer("aaa"));
		System.out.println(queue.offer("bbb"));
		System.out.println(queue);
	}
}
