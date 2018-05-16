package com.xw.study.thread.multi001._005;

/**
 * 重入锁，其实还是对象锁，同步方法1中 执行 同步方法2，是可以直接进去的，不需要重新抢锁
 */
public class SyncDubbo1 {

	public synchronized void method1() {
		System.out.println("线程：" + Thread.currentThread().getName() + "method1");
		method2();
	}
	public synchronized void method2() {
		System.out.println("线程：" + Thread.currentThread().getName() + "method2");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		method3();
	}
	public synchronized void method3() {
		System.out.println("线程：" + Thread.currentThread().getName() + "method3");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		final SyncDubbo1 dubbo = new SyncDubbo1();
		Thread thread1 = new Thread("t1"){
			public void run() {
				dubbo.method1();
			};
		};
		Thread thread2 = new Thread("t2"){
			public void run() {
				dubbo.method3();
			};
		};
		thread1.start();
		thread2.start();
	}
}
