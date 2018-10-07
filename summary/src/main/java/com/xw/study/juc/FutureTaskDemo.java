package com.xw.study.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {

	public static void main(String[] args) throws Throwable {
		FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
			@Override
			public String call() throws Exception {
				Thread.sleep(3000);
				return "end";
			}
		});
		
		ExecutorService threadPool = Executors.newCachedThreadPool();
		threadPool.submit(futureTask);
		System.out.println("----------" + futureTask.get());
		
		threadPool.shutdown();
	}
}
