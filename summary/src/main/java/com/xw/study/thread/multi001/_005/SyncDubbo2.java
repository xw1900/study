package com.xw.study.thread.multi001._005;

/**
 * 重入锁，子类调用父类中的方法也是一样的
 * @author TTX034
 *
 */
public class SyncDubbo2 {

	static class Main {
		public synchronized void main() {
			System.out.println("线程：" + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	static class Sun extends Main{
		public synchronized void sun() {
			System.out.println("线程：" + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			main();
		}
	}
	
	public static void main(String[] args) {
		final Sun sun = new Sun();
		Thread thread1 = new Thread("t1"){
			public void run() {
				sun.sun();
			};
		};
		thread1.start();

		Thread thread2 = new Thread("t2"){
			public void run() {
				sun.main();
			};
		};
		thread2.start();
	}
}
