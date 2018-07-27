package com.xw.study.thread.multi002._001;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 实现：当list中添加到第五个订单的时候，发送一个通知，处理其他的内容。 试下 wait notify。
 * wait 和 notify 都需要在同步中才能调用，且wait释放锁，notify不释放锁，
 * 且JDK不推荐在线程实例上使用wait，notify和notifyAll方法。
 * 
 * 此例中虽然在添加到第五个的时候发出了通知，但不释放锁，只能在处理完成后才会释放锁，notify后面的代码才会执行。
 * 采用CountDownLatch：允许一个或多个线程一直等待，直到其他线程的操作执行到某一地步（latch减到0） 再执行
 * 
 * countdownLatch使用场景：
	1、实现最大的并行性：有时我们想同时启动多个线程，实现最大程度的并行性。（即多个线程等待某一点，然后同时恢复执行（栅栏））
	 	例如，我们想测试一个单例类。如果我们创建一个初始计数为1的CountDownLatch，
	 	并让所有线程都在这个锁上等待，那么我们可以很轻松地完成测试。
	 	我们只需调用 一次countDown()方法就可以让所有的等待线程同时恢复执行。
	2、开始执行前等待n个线程完成各自任务：（即一个线程等待其他多个线程处理完成再处理）
		例如应用程序启动类要确保在处理用户请求前，所有N个外部系统已经启动和运行了。
	3、死锁检测：一个非常方便的使用场景是，你可以使用n个线程访问共享资源，
		在每次测试阶段的线程数目是不同的，并尝试产生死锁。
 * 
 * @author TTX034
 *
 */
public class ListAdd2 {

	public static void main(String[] args) {
		List<String> list = new ArrayList();
		CountDownLatch latch = new CountDownLatch(1);

		Thread thread1 = new Thread() {
			public void run() {
					for (int i = 1; i <= 10; i++) {
						list.add(i + "");
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("thread1 list.size " + list.size());
						if (list.size() == 5) {
							latch.countDown();
							System.out.println("发出===线程notify的通知。");
						}
				}
			};
		};
		Thread thread2 = new Thread() {
			public void run() {
				System.out.println("thread2进入。");
				if (list.size() != 5) {
					try {
						latch.await();
						System.out.println("收到---线程notify的通知。list.size " + list.size());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		};
		thread2.start();
		Thread thread3 = new Thread() {
			public void run() {
				System.out.println("thread3进入。");
				if (list.size() != 5) {
					try {
						latch.await();
						System.out.println("收到---线程notify的通知。list.size " + list.size());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		};
		thread3.start();
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		thread1.start();
	}
}
