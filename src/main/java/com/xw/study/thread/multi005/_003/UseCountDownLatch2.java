package com.xw.study.thread.multi005._003;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch：类似一个计数器 比如：线程1 2 3 一起执行，但是1在执行到某处的时候 必须等2和3执行完成后 才能执行之后的步骤
 * @author TTX034
 *
 */
public class UseCountDownLatch2 {

	public static void main(String[] args) {

		/**
		 * 可以想象为有三个人，其中一个人已经在100米处了，其他两个人还在起点，在100米处的人需要等其他两个人到了100米的地方才可以往前走。
		 */
		CountDownLatch latch = new CountDownLatch(2);
		ExecutorService threadPool = Executors.newFixedThreadPool(3);

		for (int i = 1; i <= 2; i++) {
			final int j = i;
			threadPool.execute(new Thread("t" + i) {
				public void run() {
					System.out.println("线程：" + Thread.currentThread().getName() + " 执行");
					try {
						Thread.sleep(j * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("线程：" + Thread.currentThread().getName() + " 执行完成");
					latch.countDown();
				};
			});
		}
		
		System.out.println("线程：" + Thread.currentThread().getName() + " 执行");
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("线程：" + Thread.currentThread().getName() + " 执行完成");

		threadPool.shutdown();
	}
}
