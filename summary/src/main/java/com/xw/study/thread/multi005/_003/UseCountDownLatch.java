package com.xw.study.thread.multi005._003;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch：类似一个计数器
 * 比如：线程1 2 3 一起执行，但是1在执行到某处的时候 必须等2和3执行完成后 才能执行之后的步骤
 * 输出：线程：t1 执行
		线程：t2 执行
		线程：t3 执行
		线程：t2 执行完成
		线程：t3 执行完成
		线程：t1 执行完成
 * @author TTX034
 *
 */
public class UseCountDownLatch {

	public static void main(String[] args) {
		
		CountDownLatch latch = new CountDownLatch(2);
		
		Thread thread1 = new Thread("t1"){
			public void run() {
				System.out.println("线程：" + Thread.currentThread().getName() + " 执行");
				try {
					latch.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("线程：" + Thread.currentThread().getName() + " 执行完成");
			};
		};
		Thread thread2 = new Thread("t2"){
			public void run() {
				System.out.println("线程：" + Thread.currentThread().getName() + " 执行");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("线程：" + Thread.currentThread().getName() + " 执行完成");
				latch.countDown();
			};
		};
		
		Thread thread3 = new Thread("t3"){
			public void run() {
				System.out.println("线程：" + Thread.currentThread().getName() + " 执行");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("线程：" + Thread.currentThread().getName() + " 执行完成");
				latch.countDown();
			};
		};
		
		thread1.start();
		thread2.start();
		thread3.start();
	}
}
