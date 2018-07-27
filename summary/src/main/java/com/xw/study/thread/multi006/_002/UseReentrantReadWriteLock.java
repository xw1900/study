package com.xw.study.thread.multi006._002;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * 读写锁
 * 读读共享
 * 读写 写写互斥
 * 结果：
 * read 当前线程：t1 start--
read 当前线程：t2 start--
read 当前线程：t2 end--
read 当前线程：t1 end--
write 当前线程：t2 start--
write 当前线程：t2 end--
write 当前线程：t1 start--
write 当前线程：t1 end--
 * @author TTX034
 *
 */
public class UseReentrantReadWriteLock {

	private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
	private ReadLock readLock = rwLock.readLock();
	private WriteLock writeLock = rwLock.writeLock();
	
	public void read() {
		try {
			readLock.lock();
			
			System.out.println("read 当前线程：" + Thread.currentThread().getName() + " start--");
			Thread.sleep(1000);
			System.out.println("read 当前线程：" + Thread.currentThread().getName() + " end--");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			readLock.unlock();
		}
	}
	
	public void write() {
		try {
			writeLock.lock();
			
			System.out.println("write 当前线程：" + Thread.currentThread().getName() + " start--");
			Thread.sleep(1000);
			System.out.println("write 当前线程：" + Thread.currentThread().getName() + " end--");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			writeLock.unlock();
		}
	}
	
	public static void main(String[] args) {
		
		UseReentrantReadWriteLock lock = new UseReentrantReadWriteLock();
		
		Thread thread1 = new Thread("t1"){
			public void run() {
				lock.read();
				lock.write();
			};
		};
		Thread thread2 = new Thread("t2"){
			public void run() {
				lock.read();
				lock.write();
			};
		};
		thread1.start();
		thread2.start();
	}
}
