package com.xw.study.thread.multi001._006;

/**
 * 死锁，多个线程交叉持有对方需要的锁，导致线程都在等其他线程释放锁。
 * 可用  jstack -l pid 查看运行状态
 * @author TTX034
 *
 */
public class DeadLock {

	private String lock1 = "lock1";
	private String lock2 = "lock2";
	
	public void execute1() {
		synchronized (lock1) {
			System.out.println("execute1 lock1---");
			synchronized (lock2) {
				System.out.println("execute1 lock2---");
			}
		}
	}
	public void execute2() {
		synchronized (lock2) {
			System.out.println("execute2 lock2---");
			synchronized (lock1) {
				System.out.println("execute2 lock1---");
			}
		}
	}
	
	public static void main(String[] args) {
		final DeadLock dead = new DeadLock();
		Thread thread1 = new Thread("t1"){
			public void run() {
				dead.execute1();
			};
		};
		Thread thread2 = new Thread("t2"){
			public void run() {
				dead.execute2();
			};
		};
		thread1.start();
		thread2.start();
	}
}
