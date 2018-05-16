package com.xw.study.thread.multi001._002;

public class MultiThread {

	public int num = 0;
	
	/**
	 * 对象锁：针对对象，一个对象一把锁。
	 * 类锁：针对类，一个类一把锁，不管多少过对象。
	 * @param num
	 */
	public synchronized void setNum(int num) {
		
		System.out.println("线程：" + Thread.currentThread().getName() + "设置前的num：：：" + this.num);
		this.num = num;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("线程：" + Thread.currentThread().getName() + "设置后的num---" + this.num);
	}
	
	public static void main(String[] args) {
		
		final MultiThread multiThread = new MultiThread();
		
		Thread thread1 = new Thread("t1"){
			public void run() {
				multiThread.setNum(100);
			};
		};
		Thread thread2 = new Thread("t2"){
			public void run() {
				multiThread.setNum(200);
			};
		};
		
		thread1.start();
		thread2.start();
	}
}
