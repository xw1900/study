package com.xw.study.thread.multi001._006;

/**
 * 锁对象中属性的改变不会影响锁本身的作用。
 * 但是，锁对象被新new了一个，就会改变了
 * */
public class ModifyLock {

	private People lock = new People("张三", "123");

	public void execute() {

		synchronized (lock) {

			System.out.println(Thread.currentThread().getName() + " begin!");
			// 锁对象属性的改变不会影响锁
//			lock.setName("李四");
			
			// 锁对象被新new了一个，就会改变了
			lock = new People("张三", "123");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " end!");
		}
	}

	public static void main(String[] args) {

		final ModifyLock lock = new ModifyLock();
		Thread thread1 = new Thread("t1") {
			public void run() {
				lock.execute();
			};
		};
		Thread thread2 = new Thread("t2") {
			public void run() {
				lock.execute();
			};
		};
		thread1.start();
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		thread2.start();
	}

	static class People {
		private String name;
		private String pwd;

		public People() {
		}

		public People(String name, String pwd) {
			super();
			this.name = name;
			this.pwd = pwd;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPwd() {
			return pwd;
		}

		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
	}
}
