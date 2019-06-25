package com.xw.study.juc.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsTest {

	public static void main(String[] args) throws Exception {
//		testNewCachedThreadPool();
//		testNewFixedThreadPool();
		System.out.println(testTry());
		
	}

	private static int testTry() {
		try{
//			int i = 1/0;
			return 1;
		}catch (Exception e) {
			return 2;
		}finally {
//			return 3;
		}
	}

	private static void testNewFixedThreadPool() throws Exception {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 1; i++) {
//			executorService.execute(new Runnable() {
//				@Override
//				public void run() {
//					System.out.println(Thread.currentThread().getName());
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			});
			Future<String> submit = executorService.submit(new Callable<String>() {

				@Override
				public String call() throws Exception {
					return "hi";
				}
			});
			System.out.println(submit.get());
		}
		executorService.shutdown();
	}

	private static void testNewCachedThreadPool() {
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
//			executorService.execute(new Runnable() {
//				@Override
//				public void run() {
//					System.out.println(Thread.currentThread().getName());
//				}
//			});
			Future<String> submit = executorService.submit(new Callable<String>() {

				@Override
				public String call() throws Exception {
					return "hi";
				}
			});
		}
		executorService.shutdown();
	}
}
