package com.xw.study.thread.multi001._004;

public class DirtyRead {
	
	private String name;
	private String pwd;
	
	/**
	 * 需要保证原子性，设置就要一起设置，中间不能有干扰
	 * @param name
	 * @param pwd
	 */
	public synchronized void setValue(String name, String pwd) {
		System.out.println("设置前获取。。。name：" + this.name + " pwd：" + this.pwd);
		this.name = name;
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		this.pwd = pwd;
		
		System.out.println("设置后获取。。。name：" + this.name + " pwd：" + this.pwd);
	}
	
	public void getValue() {
		System.out.println("获取---name：" + this.name + " pwd：" + this.pwd);
	}
	
	public static void main(String[] args) {
		
		final DirtyRead read = new DirtyRead();
		
		Thread thread1 = new Thread(){
			public void run() {
				read.setValue("张三", "123");
				read.getValue();
			};
		};
		Thread thread2 = new Thread(){
			public void run() {
				read.setValue("李四", "456");
				read.getValue();
			};
		};
		
		thread1.start();
		thread2.start();
	}
}
