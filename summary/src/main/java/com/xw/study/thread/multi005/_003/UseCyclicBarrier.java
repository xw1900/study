package com.xw.study.thread.multi005._003;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 让一组线程等待至某个状态后再全部执行
 * 让多少个线程或者任务等待至barrier状态
 * 例子：多个线程一起执行，速度不一样，等所有线程执行到一定程度 再一起往下走
 * @author TTX034
 *
 */
public class UseCyclicBarrier {

	public static void main(String[] args) {
		
		/**
		 * 可以想象为3个人走路，走的速度都不一样，走到一定的程度时，比如100米时，有3个栅栏拦着，需要这三个人每人拿掉一把，然后才可以一起走
		 */
		CyclicBarrier barrier = new CyclicBarrier(3);// 3即代表着有3个线程一起执行
		
		Thread thread1 = new Thread("t1"){
			@Override
			public void run() {
				System.out.println("线程：" + Thread.currentThread().getName() + " 开始执行");
				try {
					Thread.sleep(3000);
					System.out.println("线程：" + Thread.currentThread().getName() + " 开始等待其他线程执行完");
					barrier.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
				System.out.println("线程：" + Thread.currentThread().getName() + " 执行完成");
			}
		};
		Thread thread2 = new Thread("t2"){
			@Override
			public void run() {
				System.out.println("线程：" + Thread.currentThread().getName() + " 开始执行");
				try {
					Thread.sleep(2000);
					System.out.println("线程：" + Thread.currentThread().getName() + " 开始等待其他线程执行完");
					barrier.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
				System.out.println("线程：" + Thread.currentThread().getName() + " 执行完成");
			}
		};
		Thread thread3 = new Thread("t3"){
			@Override
			public void run() {
				System.out.println("线程：" + Thread.currentThread().getName() + " 开始执行");
				try {
					Thread.sleep(1000);
					System.out.println("线程：" + Thread.currentThread().getName() + " 开始等待其他线程执行完");
					barrier.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
				System.out.println("线程：" + Thread.currentThread().getName() + " 执行完成");
			}
		};
		
		thread1.start();
		thread2.start();
		thread3.start();
	}
}
