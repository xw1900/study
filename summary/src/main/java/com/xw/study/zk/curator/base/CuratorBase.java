package com.xw.study.zk.curator.base;

public class CuratorBase {

	// 连接地址
	static String CONNECT_ADDR = "192.168.110.97:2181";
	// 会话超时时间
	static int SESSION_OUTTIME = 5000;
	// 测试父节点
	static String PARENT_NODE = "/parent-node";
	// 测试子节点
	static String CHILDREN_NODE = "/parent-node/children-node";
	// 临时节点
	static String TEMP_NODE = "/temp";
	
	public static void main(String[] args) {
		
	}
}
