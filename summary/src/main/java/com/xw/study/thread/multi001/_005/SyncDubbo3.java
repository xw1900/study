package com.xw.study.thread.multi001._005;

/**
 * 注意这种静态方法的 同步不一样，sun静态方法  和  main静态方法  已经不是同一个类了
 * @author TTX034
 *
 */
public class SyncDubbo3 {

	static class Main {
		public static synchronized void main() {
			System.out.println("线程：" + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	static class Sun extends Main{
		public static synchronized void sun() {
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

		Thread thread1 = new Thread("t1"){
			public void run() {
				Sun.sun();
			};
		};
		Thread thread2 = new Thread("t2"){
			public void run() {
				Sun.main();
			};
		};
		
		thread1.start();
		thread2.start();
	}
}
