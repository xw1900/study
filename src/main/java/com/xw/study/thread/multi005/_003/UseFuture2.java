package com.xw.study.thread.multi005._003;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UseFuture2 {

	public static void main(String[] args) throws Exception {
		ExecutorService threadPool = Executors.newFixedThreadPool(3);

		Future<?> future = threadPool.submit(new Thread() {
			@Override
			public void run() {
				System.out.println("线程：" + Thread.currentThread().getName() + " 开始执行");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("线程：" + Thread.currentThread().getName() + " 执行完成");
			}
		});

		// future还没执行完时会阻塞在此处
		System.out.println(future.get());
		threadPool.shutdown();
	}
}
