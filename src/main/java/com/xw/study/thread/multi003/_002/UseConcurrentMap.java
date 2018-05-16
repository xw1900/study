package com.xw.study.thread.multi003._002;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap默认将hash表分为16个桶，每个桶一把锁。1.8有些变化，有更进一步的改进。
 * Hashtable则是整个表一把锁，
 * @author TTX034
 *
 */
public class UseConcurrentMap {

	public static void main(String[] args) {
		ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<>();
	}
}
