package com.xw.study.thread.multi005._003;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量：一次允许多少个线程执行，可以控制同时访问的线程个数
 * 使用：通过 acquire() 获取一个许可，如果没有就等待，而 release()释放一个许可。
 * @author TTX034
 *
 */
public class UseSemaphore {

	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		// 只允许5个线程同时访问
		Semaphore semaphore = new Semaphore(5);
		for (int i = 1; i <= 20; i++) {
			final int j = i;
			threadPool.execute(new Thread("t" + j) {
				@Override
				public void run() {
					try {
						semaphore.acquire();// 获取许可
						System.out.println("线程：" + Thread.currentThread().getName() + " 开始执行");
						Thread.sleep(2000);
						System.out.println("线程：" + Thread.currentThread().getName() + " 执行完成");
						semaphore.release();// 释放
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}

		threadPool.shutdown();
	}
}
