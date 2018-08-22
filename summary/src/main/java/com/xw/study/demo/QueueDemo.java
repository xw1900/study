package com.xw.study.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class QueueDemo {

	public static void main(String[] args) throws InterruptedException {

		BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(2);
		BlockingQueue<Runnable> queue2 = new LinkedBlockingQueue<>();
		BlockingQueue<Runnable> queue3 = new LinkedBlockingQueue<>(1);
		
		
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 60, TimeUnit.SECONDS, queue3);
		
		Thread thread1 = new Thread() {
			public void run() {
				System.out.println("----------thread1---------");
				try {
					Thread.sleep(10000000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
		};
		Thread thread2 = new Thread() {
			public void run() {
				System.out.println("----------thread2---------");
				try {
					Thread.sleep(10000000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
		};
		Thread thread3 = new Thread() {
			public void run() {
				System.out.println("----------thread3---------");
				try {
					Thread.sleep(10000000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
		};
		Thread thread4 = new Thread() {
			public void run() {
				System.out.println("----------thread4---------");
				try {
					Thread.sleep(10000000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
		};
		pool.execute(thread1);
		Thread.sleep(100);
		pool.execute(thread2);
		Thread.sleep(100);
		pool.execute(thread3);
		Thread.sleep(100);
		pool.execute(thread4);
	}
}
