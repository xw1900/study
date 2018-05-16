package com.xw.study.thread.multi005._002;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 不含拒绝策略的队列
 * @author TTX034
 *
 */
public class UseThreadPoolExecutor {

	public static void main(String[] args) {
		
		BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(5);
		
		ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
				1, // 核心线程数
				5, // 最大线程数
				60, // 线程空闲多长时间被销毁
				TimeUnit.SECONDS, // 空闲时间单位 
				queue // 指定队列
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
		 * 输出：1 9 8 7 10 2 5 6 3 4
		 * 分析：核心线程为1，最大线程为5，队列长度为5,
		 * 		第1个runnable：因为核心线程数为1，一进来就执行了
		 * 		第2-6个runnable：因为队列长度为5，所以被放到了队列中
		 * 		第7-10个runnable：因为最大线程数为5，7-10有4个，包括核心的1个，共5个，所以被直接执行了
		 * 			所以是先执行第一个，然后7 8 9 10，最后是2 3 4 5 6
		 */
	}
	
}
