package com.xw.study.thread.multi005._003;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 异步获取多线程的执行结果
 * 可以实现：1.启动多线程任务 2.处理其他事 3.收集多线程任务结果。
 * @author TTX034
 *
 */
public class UseFuture {

	public static void main(String[] args) throws Exception {
		ExecutorService threadPool = Executors.newFixedThreadPool(3);

		// 1、启动多线程任务
		Future<String> future = threadPool.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("开始执行---");
				Thread.sleep(3000);
				System.out.println("执行完毕---");
				return "执行结果---";
				
			}
		});
		
		// 2、处理其他事
		Thread.sleep(2000);

		// future还没执行完时会阻塞在此处
		// 3、收集多线程任务结果
		System.out.println(future.get());
		threadPool.shutdown();
	}
}
