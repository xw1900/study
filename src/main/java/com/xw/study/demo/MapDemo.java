package com.xw.study.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * map是 数组和链表来实现对数据的存储
 *
 */
public class MapDemo {

	public static void main(String[] args) {
		testHashMap();
	}
	
	private static void testHashMap() {
		/**
		 * HashMap(int initialCapacity) 初始化大小默认容量是16，扩展因子是0.75
		 * 相当于存了12就会扩容，所以尽量遵循：  initialCapacity = (需要存储的元素个数 / 负载因子) + 1。
		 * 比如需要存1200，那么容量最好设置为(1200/0.75)+1 = 1601，最好是初始化的时候就确定大小，免得需要resize，
		 * resize 需要重建 hash 表，严重影响性能
		 * 为什么是0.75？：负载系数0.75  在时间和空间成本上提供了很好的折衷
		 */
		Map<String, String> map = new HashMap<>(16);
		map.put("aaa", "aaa");
		
		
		/**
		 * HashMap为什么线程不安全?
		 * 1、在两个线程同时尝试扩容HashMap时，可能将一个链表形成环形的链表，所有的next都不为空，进入死循环
		 * 2、在两个线程同时进行put时可能造成一个线程数据的丢失
		 */
		
		
		/**
		 * 	集合类 					Key 		Value 		Super 		说明
		 * 	Hashtable 			不允许为 null 	不允许为 null 	Dictionary 		线程安全
		 * 	ConcurrentHashMap 	不允许为 null 	不允许为 null 	AbstractMap 	锁分段技术（JDK8:CAS）
		 * 	TreeMap 			不允许为 null 	允许为 null 	AbstractMap 	线程不安全
		 * 	HashMap 			允许为 null 	允许为 null 	AbstractMap 	线程不安全
		 */
		
		
	}
}
