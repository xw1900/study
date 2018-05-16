package com.xw.study.thread.multi002._002;

import java.util.LinkedList;

/**
 * 模拟队列的存放和取出
 	先判断队列允许的长度，存放的时候
 		put：如果发现此时队列的长度 大于最大长度了，就wait
 		take：如果发现此时队列的长度 小于最小长度了，就wait
 	每次put take完后都唤醒wait的线程，让他们也一起抢锁
 * @author TTX034
 *
 */
public class MyQueue {

	private LinkedList<String> queue = new LinkedList<>();

	private Object lock = new Object();

	private int minSize = 0;

	private int maxSize = 0;

	public MyQueue(int max) {
		this.maxSize = max;
	}

	public void put(String param) {
		if (maxSize <= 0) {
			throw new RuntimeException("容器长度需要大于0！");
		}

		synchronized (lock) {
			if (queue.size() >= maxSize) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			queue.add(param);
			lock.notify();
			System.out.println("新加入的元素：" + param);
		}

	}

	public String take() {
		String result = "";
		if (maxSize <= 0) {
			throw new RuntimeException("容器长度需要大于0！");
		}

		synchronized (lock) {
			if (queue.size() <= minSize) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			result = queue.removeFirst();
			lock.notify();
			System.out.println("取出的元素：" + result);
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		MyQueue queue = new MyQueue(10);
		
		Thread thread1 = new Thread("t1"){
			public void run() {
				for (int i = 0; i < 1000; i++) {
					queue.put("i" + i);
				}
			};
		};
		Thread thread2 = new Thread("t2"){
			public void run() {
				for (int i = 0; i < 1000; i++) {
					queue.take();
				}
			};
		};
//		thread1.start();
		thread2.start();
	}
}
