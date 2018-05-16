package com.xw.study.thread.multi001._005;

public class SyncException {

	private int num = 0;

	public void setNum() {
		
		while (true) {
			num++;
			try {
				Thread.sleep(100);
				if (num == 10) {
					throw new RuntimeException();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("线程：" + Thread.currentThread().getName() + " num:" + num);
		}
	}

	public static void main(String[] args) {

		final SyncException ex = new SyncException();

		Thread thread = new Thread() {
			public void run() {
				ex.setNum();
			};
		};
		thread.start();
	}
}
