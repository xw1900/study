package com.xw.study.thread.multi005._002;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 含拒绝策略的队列
 * @author TTX034
 *
 */
public class UseThreadPoolExecutor2 {

	public static void main(String[] args) {
		
		BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(5);
		
		ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
				1, // 核心线程数
				5, // 最大线程数
				60, // 线程空闲多长时间被销毁
				TimeUnit.SECONDS, // 空闲时间单位 
				queue, // 指定队列
				new MyRejected()
				);
		
		for (int i = 1; i <= 11; i++) {
			final int j = i;
			poolExecutor.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println(j + "");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
		/**
		 * 输出：1 8 7 9 10 拒绝策略 2 5 4 3 6
		 * 分析：核心线程为1，最大线程为5，队列长度为5,
		 * 		第1个runnable：因为核心线程数为1，一进来就执行了
		 * 		第2-6个runnable：因为队列长度为5，所以被放到了队列中
		 * 		第7-11个runnable：因为最大线程数为5，7-11有5个包括核心的1个，共有6个，所以执行了前5个，最后一个被拒绝了
		 * 			所以是先执行第一个，然后7 8 9 10，第11个走了拒绝策略，最后是2 3 4 5 6
		 */
	}
	
	static class MyRejected implements RejectedExecutionHandler{
		public MyRejected() {
			
		}

		@Override
		public void rejectedExecution(Runnable runnable, ThreadPoolExecutor paramThreadPoolExecutor) {
			System.out.println("拒绝策略：" + runnable.toString());
		}
	}
}
