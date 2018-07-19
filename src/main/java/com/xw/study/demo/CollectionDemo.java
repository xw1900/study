package com.xw.study.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionDemo {

	public static void main(String[] args) {
//		testSubList();
//		testList2Array();
//		testArray2List();
//		testforeach();
		
		
	}
	
	private static void testforeach() {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
//		for (String item : list) {
//			if ("2".equals(item)) {
//				list.remove(item);
//			}
//		}
		for (int i = 0; i < list.size(); i++) {
			if ("2".equals(list.get(i))) {
				list.remove(list.get(i));
			}
		}
		System.out.println(list);
	}

	private static void testArray2List() {
		String[] strs = new String[]{"aaa", "bbb", "ccc"};
		
		// asList 的返回对象是一个 Arrays 内部类，并没有实现集合的修改方法
		// Arrays.asList体现的是适配器模式，只是转换接口，后台的数据仍是数组。
		
		// 该方法不适用于基本数据类型（byte,short,int,long,float,double,boolean）
		int[] ints = new int[]{1, 2, 3};
		List<int[]> list2 = Arrays.asList(ints);// 它把ints当成一个元素
		
		
		List<String> list = Arrays.asList(strs);
		
		// 不支持add和remove方法
//		list.add("ddd");// 报错
		System.out.println(list);// [aaa, bbb, ccc]
		
		
		strs[0] = "ddd";
		// 该方法将数组与列表链接起来，当更新其中之一时，另一个自动更新
		System.out.println(list);// [ddd, bbb, ccc]
	}

	private static void testList2Array() {
		List<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		
		String[] strs = new String[list.size()];
		strs = list.toArray(strs);
		System.out.println(strs[0] + strs[1] + strs[2]);
	}

	/**
	 * 1，该方法返回的是父list的一个视图，从fromIndex（包含），到toIndex（不包含）。fromIndex=toIndex 表示子list为空
	 * 2，父子list做的非结构性修改（non-structural changes）都会影响到彼此：
	 * 		所谓的“非结构性修改”，是指不涉及到list的大小改变的修改。相反，结构性修改，指改变了list大小的修改。
	 * 3，对于结构性修改，子list的所有操作都会反映到父list上。但父list的修改将会导致返回的子list失效。
	 * 4，tips：如何删除list中的某段数据：list.subList(from, to).clear();
	 */
	private static void testSubList() {
		List<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		List<String> subList = list.subList(0, 2);
		
		System.out.println(list);
		System.out.println(subList);
		
		
		// 父子list做的非结构性修改（non-structural changes）都会影响到彼此
		// 所谓的“非结构性修改”，是指不涉及到list的大小改变的修改。相反，结构性修改，指改变了list大小的修改。
		
		
		// 对于结构性修改，子list的所有操作都会反映到父list上
		subList.add("ddd");
		System.out.println(list);
		System.out.println(subList);
		
		// 但父list的修改将会导致返回的子list失效
//		list.add("eee");
//		System.out.println(list);
//		System.out.println(subList);// 报错
		
		// tips：如何删除list中的某段数据：list.subList(from, to).clear();
		list.subList(1, 3).clear();
		System.out.println(list);
	}
}
