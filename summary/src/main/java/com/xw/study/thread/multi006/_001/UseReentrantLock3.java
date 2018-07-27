package com.xw.study.thread.multi006._001;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock Condition 条件
 * 睡眠和唤醒是同一个condition就可以
 * @author TTX034
 *
 */
public class UseReentrantLock3 {
	
	ReentrantLock lock = new ReentrantLock();
	Condition condition1 = lock.newCondition();
	Condition condition2 = lock.newCondition();
	
	public void method1(){
		lock.lock();
		System.out.println("线程：" + Thread.currentThread().getName() + " method1开始执行");
		
		try {
			Thread.sleep(1000);
			condition1.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("线程：" + Thread.currentThread().getName() + " method1执行完成");
		lock.unlock();
	}
	
	public void method2(){
		lock.lock();
		System.out.println("线程：" + Thread.currentThread().getName() + " method2开始执行");
		
		condition2.signal();
		
		System.out.println("线程：" + Thread.currentThread().getName() + " method2执行完成");
		lock.unlock();
	}

	public static void main(String[] args) {
		UseReentrantLock3 lock = new UseReentrantLock3();
		Thread thread1 = new Thread("t1"){
			public void run() {
				lock.method1();
			};
		};
		Thread thread2 = new Thread("t2"){
			public void run() {
				lock.method2();
			};
		};
		thread1.start();
		thread2.start();
	}
}
