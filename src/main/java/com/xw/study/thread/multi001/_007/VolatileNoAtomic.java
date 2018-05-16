package com.xw.study.thread.multi001._007;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile 和 原子性没有关系，一个方法内要具有原子性得加同步才行
 * @author TTX034
 *
 */
public class VolatileNoAtomic extends Thread {
	
	private static volatile AtomicInteger count = new AtomicInteger(0);
	
	public void run() {
		add();
	}
	public synchronized static void add(){
		for (int i = 0; i < 1000; i++) {
			count.incrementAndGet();
		}
		System.out.println("count=" + count);
	}

	public static void main(String[] args) {

		VolatileNoAtomic[] arr = new VolatileNoAtomic[100];
		for (int i = 0; i < 10; i++) {
			arr[i] = new VolatileNoAtomic();
		}

		for (int i = 0; i < 10; i++) {
			arr[i].start();
		}
	}
}
