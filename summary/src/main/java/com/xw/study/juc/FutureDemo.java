package com.xw.study.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {
	static class MyRunable implements Runnable {

		@Override
		public void run() {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	static class MyCallable implements Callable<String> {

		@Override
		public String call() throws Exception {
			Thread.sleep(3000);
			return "end";
		}
	}
	public static void main(String[] args) throws Exception {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		Future<String> future = threadPool.submit(new MyCallable());// 有返回值
//		Future<?> future = threadPool.submit(new MyRunable());// 无返回值

		System.out.println("-----------111111");
		System.out.println("--------------" + future.get());
		threadPool.shutdown();
	}
}
