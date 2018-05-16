package com.xw.study.thread.multi001._006;

/**
 * synchronized直接加在方法上和synchronized(this)都是对当前对象加锁
 * @author TTX034
 *
 */
public class ObjectLock2 {

	public void method1() {
		synchronized (this) {
			try {
				System.out.println("method1-begin");
				Thread.sleep(2000);
				System.out.println("method1-end");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public synchronized void method2() {

		try {
			System.out.println("method2-begin");
			Thread.sleep(2000);
			System.out.println("method2-end");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {

		final ObjectLock2 lock = new ObjectLock2();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				lock.method1();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				lock.method2();
			}
		});

		t2.start();
		t1.start();

	}
}
