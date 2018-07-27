package com.xw.study.thread.multi001._001;

public class MyThread implements Runnable {

	private int count = 0;
	
	// // 会存在锁竞争的问题，导致count不准
	// public void run() {
	// try {
	// Thread.sleep(20);
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	// count ++ ;
	// System.out.println(Thread.currentThread().getName() + " count:" + count);
	// }
	
	// synchronized，进方法前，先队列中等锁，别的线程释放锁后再抢锁。
	// MyThread一个对象一把锁。
		public synchronized void run() {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count ++ ;
			System.out.println(Thread.currentThread().getName() + " count:" + count);
		}
	
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		
		Thread[] threads = new Thread[100];
		for (int i = 1; i <= 100; i++) {
			Thread thread = new Thread(myThread, "t" + i);
			threads[i-1] = thread;
		}
		for (Thread thread : threads) {
			thread.start();
		}
	}
}
