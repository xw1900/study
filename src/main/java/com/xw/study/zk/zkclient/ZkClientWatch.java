package com.xw.study.zk.zkclient;

import java.util.List;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.ZkConnection;

/**
 * zkClient的api使用
 * @author TTX034
 *
 */
public class ZkClientWatch {

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
	
	public static void main(String[] args) throws Exception {
		ZkClient client = new ZkClient(new ZkConnection(CONNECT_ADDR, SESSION_OUTTIME));
		
		// 订阅子节点变更通知
		client.subscribeChildChanges(PARENT_NODE, new IZkChildListener() {
			@Override
			public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
				System.out.println("parentPath: " + parentPath + " currentChilds: " + currentChilds);
			}
		});
		client.subscribeChildChanges(CHILDREN_NODE, new IZkChildListener() {
			@Override
			public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
				System.out.println("parentPath: " + parentPath + " currentChilds: " + currentChilds);
			}
		});
		
		// 订阅节点数据变更通知（节点数据变化，节点被删除）
		client.subscribeDataChanges(PARENT_NODE, new IZkDataListener() {
			@Override
			public void handleDataDeleted(String path) throws Exception {
				System.out.println("删除的节点为:" + path);
			}
			@Override
			public void handleDataChange(String path, Object data) throws Exception {
				System.out.println("变更的节点为:" + path + ", 变更内容为:" + data);
			}
		});
		client.subscribeDataChanges(CHILDREN_NODE, new IZkDataListener() {
			@Override
			public void handleDataDeleted(String path) throws Exception {
				System.out.println("删除的节点为:" + path);
			}
			@Override
			public void handleDataChange(String path, Object data) throws Exception {
				System.out.println("变更的节点为:" + path + ", 变更内容为:" + data);
			}
		});
		
		// 收到两个通知，节点创建通知，数据变更通知
		client.createPersistent(PARENT_NODE, "parent-node-data");
//		client.createPersistent(CHILDREN_NODE, true);
		
		Thread.sleep(5000);
		
	}
}
