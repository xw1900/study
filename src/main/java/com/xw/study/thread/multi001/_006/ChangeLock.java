package com.xw.study.thread.multi001._006;


public class ChangeLock {

	private String lock = "lock";
	
	public void change() {
		
		/**
		 * 锁改变后 分两种情况：
		 * 1、其他线程已经在队列中抢lock这把锁了，那改变了lock也还是会等待
		 * 2、其他线程没有在队列中抢lock，而是在lock改变后才来的，那就不会等lock这把锁，而是changelock这把锁。
		 */
		synchronized (lock) {
		
			System.out.println(Thread.currentThread().getName() + " begin!");
			lock = "change lock";
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
			System.out.println(Thread.currentThread().getName() + " end!");
		}
	}
	
	public static void main(String[] args) {
		
		final ChangeLock lock = new ChangeLock();
		Thread thread1 = new Thread("t1"){
			public void run() {
				lock.change();
			};
		};
		Thread thread2 = new Thread("t2"){
			public void run() {
				lock.change();
			};
		};
		thread1.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread2.start();
	}
}
