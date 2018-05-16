package com.xw.study.thread.multi002._001;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现：当list中添加到第五个订单的时候，发送一个通知，处理其他的内容。 试下 wait notify。
 * wait 和 notify 都需要在同步中才能调用，且wait释放锁，notify不释放锁，
 * 所以此例中虽然在添加到第五个的时候发出了通知，但不释放锁，只能在处理完成后才会释放锁，notify后面的代码才会执行。
 * 
 * @author TTX034
 *
 */
public class ListAdd {

	public static void main(String[] args) {
		List<String> list = new ArrayList();

		Thread thread1 = new Thread() {
			public void run() {
				synchronized (list) {
					for (int i = 1; i <= 10; i++) {
						list.add(i + "");
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("thread1 list.size " + list.size());
						if (list.size() == 5) {
							list.notify();
							System.out.println("发出===线程notify的通知。");
						}
					}
				}
			};
		};
		Thread thread2 = new Thread() {
			public void run() {
				synchronized (list) {
					if (list.size() != 5) {
						try {
							list.wait();
							System.out.println("收到---线程notify的通知。list.size " + list.size());
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			};
		};
		thread2.start();
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		thread1.start();
	}
}
