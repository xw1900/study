package com.xw.study.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import com.xw.study.juc.annotation.NotThreadSafe;

@NotThreadSafe
public class ConcurrencyTest {

	private static int clientTotal = 5000;// 请求总数
	private static int threadTotal = 200;// 并发执行线程数
	private static int count = 0;
	
	public static void main(String[] args) throws Exception {
		CountDownLatch latch = new CountDownLatch(clientTotal);
		Semaphore semaphore = new Semaphore(threadTotal);
		ExecutorService threadPool = Executors.newCachedThreadPool();
		System.out.println("start------");
		
		for (int i = 0; i < clientTotal; i++) {
			threadPool.execute(() -> {
				try {
					semaphore.acquire();
					add();
					semaphore.release();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				latch.countDown();
			});
		}
		latch.await();
		threadPool.shutdown();
		System.out.println("end---------" + count);
	}
	
	public static void add(){
		count++;
	}
}
