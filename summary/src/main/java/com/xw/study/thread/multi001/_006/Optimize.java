package com.xw.study.thread.multi001._006;

public class Optimize {

	public void method1() {
		
		System.out.println("线程" + Thread.currentThread().getName() + " do long time task!");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		// 竞争的资源加锁
		synchronized (this) {
			try {
				System.out.println("线程" + Thread.currentThread().getName() + " method1-begin");
				Thread.sleep(1000);
				System.out.println("线程" + Thread.currentThread().getName() + " method1-end");
			} catch (Exception e) {
			}
		}
	}
	
	public static void main(String[] args) {

		final Optimize optimize = new Optimize();
		Thread t1 = new Thread("t1") {
			@Override
			public void run() {
				optimize.method1();
			}
		};
		Thread t2 = new Thread("t2") {
			@Override
			public void run() {
				optimize.method1();
			}
		};

		t2.start();
		t1.start();
	}
}
