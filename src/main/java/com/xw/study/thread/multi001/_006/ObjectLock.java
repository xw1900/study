package com.xw.study.thread.multi001._006;

/**
 * 对象锁用来控制实例方法 类锁用来控制静态方法
 * 对象锁 和 类锁 是不冲突的
 * @author TTX034
 *
 */
public class ObjectLock {

	public void method1(){
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
	
	public void method2(){
		synchronized (ObjectLock.class) {
			try {
				System.out.println("method2-begin");
				Thread.sleep(2000);
				System.out.println("method2-end");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public static void main(String[] args) {
		
		final ObjectLock lock = new ObjectLock();
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
