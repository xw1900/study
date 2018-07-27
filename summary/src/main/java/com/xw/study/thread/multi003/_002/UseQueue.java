package com.xw.study.thread.multi003._002;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 队列：线程安全的队列有两种实现方式一种是使用阻塞算法，另一种是使用非阻塞算法
 * 阻塞算法：用一个锁（入队和出队用同一把锁）或两个锁（入队和出队用不同的锁）等方式来实现，
 * 非阻塞：使用循环CAS的方式来实现
 * @author TTX034
 *
 */
public class UseQueue {

	public static void main(String[] args) throws Exception {
		// 非阻塞队列，通过循环CAS算法实现
		// ConcurrentLinkedQueue 基于链接节点的无界线程安全队列
		ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
		queue.add("aaa");
		
		/**
		 * 阻塞队列：通过加锁实现
		 *阻塞队列和普通队列最大不同：阻塞队列有阻塞添加和阻塞删除方法
		 *阻塞添加：当阻塞队列已满时，队列会阻塞，直到队列可以添加
		 *	添加方法：add：添加成功返回true，失败抛出异常
		 *			offer：成功返回true，如果队列已满，则返回false
		 *			put：将元素插入队列的尾部，如果队列已满，则一直阻塞
		 *阻塞删除：当阻塞队列为空时，队列会阻塞，直到队列有元素可以删除
		 *	删除方法：remove：移除指定元素，成功返回true，失败返回false
		 *			poll：获取并移除此队列的头元素，若队列为空，返回null
		 *			take：获取并移除队列的头元素，若没有元素则一直阻塞
		 */
		// 数组实现的有界阻塞队列，必须指定队列大小
		// take和put方法是同一把锁
		ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(4);
		
		arrayBlockingQueue.put("aaa");
		arrayBlockingQueue.put("ddd");
		arrayBlockingQueue.put("bbb");
		arrayBlockingQueue.put("ccc");
		
//		arrayBlockingQueue.put("hhh");// 队列已满，会阻塞在此
		System.out.println(arrayBlockingQueue.take());
		System.out.println(arrayBlockingQueue.take());
		System.out.println(arrayBlockingQueue.take());
		System.out.println(arrayBlockingQueue.take());
		
//		arrayBlockingQueue.take();// 此时队列为空，会阻塞在此
		
		// 链表实现的有界队列阻塞队列，默认值为Integer.MAX_VALUE
		// take和put方法是两把不同的锁
		LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>();
		linkedBlockingQueue.put("aaa");
		linkedBlockingQueue.put("ddd");
		linkedBlockingQueue.put("bbb");
		linkedBlockingQueue.put("ccc");
		
//		arrayBlockingQueue.put("hhh");// 队列已满，会阻塞在此
		System.out.println(linkedBlockingQueue.take());
		System.out.println(linkedBlockingQueue.take());
		System.out.println(linkedBlockingQueue.take());
		System.out.println(linkedBlockingQueue.take());
		
//		arrayBlockingQueue.take();// 此时队列为空，会阻塞在此
		
	}
}
