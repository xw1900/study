package com.xw.study.thread.multi001._007;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子类只能保证本身方法的原子性，多个方法的原子性还是需要synchronized同步来保证
 * @author TTX034
 *
 */
public class AtomicUse {
	
	private AtomicInteger count = new AtomicInteger(0);
	
	public synchronized int add(){
		try {
			count.addAndGet(1);
			Thread.sleep(10);
			count.addAndGet(2);
			Thread.sleep(10);
			count.addAndGet(3);
			Thread.sleep(10);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return count.addAndGet(4);
	}

	public static void main(String[] args) {
		final AtomicUse atomicUse = new AtomicUse();
		
		List<Thread> lists = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			lists.add(new Thread("t" + i){
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName() + " " + atomicUse.add());
				}
			});
		}
		
		for (Thread thread : lists) {
			thread.start();
		}
	}
}
