package com.xw.study.thread.multi001._006;

public class StringLock {

	public void method1() {

		synchronized ("这是字符串") {
			try {
				System.out.println("线程" + Thread.currentThread().getName() + " method1-begin");
				Thread.sleep(1000);
				System.out.println("线程" + Thread.currentThread().getName() + " method1-end");
			} catch (Exception e) {
			}
		}
	}

	public static void main(String[] args) {

		final StringLock stringLock = new StringLock();
		Thread t1 = new Thread("t1") {
			@Override
			public void run() {
				stringLock.method1();
			}
		};
		Thread t2 = new Thread("t2") {
			@Override
			public void run() {
				stringLock.method1();
			}
		};

		t2.start();
		t1.start();
	}
}
