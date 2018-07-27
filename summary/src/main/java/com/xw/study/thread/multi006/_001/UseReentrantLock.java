package com.xw.study.thread.multi006._001;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 锁
 * @author TTX034
 *
 */
public class UseReentrantLock {
	
	ReentrantLock lock = new ReentrantLock();
	
	public void method1(){
		lock.lock();
		System.out.println("线程：" + Thread.currentThread().getName() + " method1开始执行");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("线程：" + Thread.currentThread().getName() + " method1执行完成");
		lock.unlock();
	}
	
	public void method2(){
		lock.lock();
		System.out.println("线程：" + Thread.currentThread().getName() + " method2开始执行");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("线程：" + Thread.currentThread().getName() + " method2执行完成");
		lock.unlock();
	}

	public static void main(String[] args) {
		UseReentrantLock lock = new UseReentrantLock();
		Thread thread1 = new Thread("t1"){
			public void run() {
				lock.method1();
				lock.method2();
			};
		};
		Thread thread2 = new Thread("t2"){
			public void run() {
				lock.method1();
				lock.method2();
			};
		};
		thread1.start();
		thread2.start();
	}
}
