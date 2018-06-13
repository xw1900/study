package com.xw.study.zk.zkclient;

import java.util.List;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.ZkConnection;

/**
 * zkClient的api简单使用
 * @author TTX034
 *
 */
public class ZkClientBase {

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

		ZkClient client = new ZkClient(new ZkConnection(CONNECT_ADDR, SESSION_OUTTIME));
		client.createPersistent(CHILDREN_NODE, true);// true代表创建父节点
//		client.createPersistent(PARENT_NODE, "parent-node-data");// true代表创建父节点
		client.createEphemeral(TEMP_NODE, "temp-data");
		
		List<String> children = client.getChildren(PARENT_NODE);
		System.out.println(children);// [children-node]，只有子节点名称
		
		client.writeData(CHILDREN_NODE, "children-node-data");
		System.out.println(client.readData(CHILDREN_NODE).toString());// children-node-data
		
		System.out.println(client.exists(PARENT_NODE));// Boolean类型true
		
		client.deleteRecursive(PARENT_NODE);
	}
}
