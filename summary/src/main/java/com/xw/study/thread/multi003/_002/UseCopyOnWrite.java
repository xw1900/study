package com.xw.study.thread.multi003._002;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * cow是计算机中通用的一种策略，读写分离的思想，读和写不同的容器。
 * 修改的时候，copy一个副本出去改，改完再将之前的引用指向修改后的。
 * 用于读多写少的并发场景。
 * 
 * 注意：只保证了最终一致性。改动的不会立即生效
 * @author TTX034
 *
 */
public class UseCopyOnWrite {

	public static void main(String[] args) {
		// add的时候，有加锁，只copy了一个副本出来，不然copy多个出来 改完后指向会出问题。读的时候就无所谓了。
		// 用于读多写少的并发场景
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
		list.add("aaa");
		
		// 类似于CopyOnWriteArrayList
		CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();
		set.add("bbb");
	}
}
