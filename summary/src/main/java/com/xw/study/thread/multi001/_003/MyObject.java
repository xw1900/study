package com.xw.study.thread.multi001._003;

public class MyObject {

	
	/**
	 * 对象锁，是锁住对象中的所有方法，A持有B对象锁，其他对象就不能进去B的任何同步方法，但可以进去非同步方法
	 * @param num
	 */
	public synchronized void method1() {
		
		System.out.println("线程：" + Thread.currentThread().getName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void method2() {
		
		System.out.println("线程：" + Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		
		final MyObject myObject = new MyObject();
		
		Thread thread1 = new Thread("t1"){
			public void run() {
				myObject.method1();
			};
		};
		Thread thread2 = new Thread("t2"){
			public void run() {
				myObject.method2();
			};
		};
		
		thread1.start();
		thread2.start();
	}
}
