package com.xw.study.zk.zookeeper.watch;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ZookeeperWatch implements Watcher {

	// 连接地址
	static String CONNECT_ADDR = "127.0.0.1:2181";
	// 会话超时时间
	static int SESSION_OUTTIME = 5000;
	
	static CountDownLatch latch = new CountDownLatch(1);
	
	static ZooKeeper zk;
	// 测试父节点
	static String PARENT_NODE = "/parent-node";
	// 测试子节点
	static String CHILDREN_NODE = "/parent-node/children-node";
	
	public static void main(String[] args) throws Exception {
		ZookeeperWatch watch = new ZookeeperWatch();
		watch.createZookeeper();// 创建zk
		watch.deleteAllTestNodes();// 删除所有测试节点
		
		
		System.out.println("-----------------------------------------【创建父节点】");
		// 创建父节点，原生api不支持递归创建和递归删除
		/**
		 * 事件状态：【SyncConnected】,事件类型：【None】，path:null
		 */
		zk.exists(PARENT_NODE, true);// 使用默认的watch监听
		zk.getChildren(PARENT_NODE, true);
		watch.createNode(PARENT_NODE, "parent-data");
		
		
//		System.out.println("-----------------------------------------【创建子节点】");
//		// 创建子节点 
//		/**
//		 * 事件状态：【SyncConnected】,事件类型：【NodeCreated】，path:/parent-node/children-node
//		 */
//		zk.exists(CHILDREN_NODE, true);// 使用默认的watch监听
//		watch.createNode(CHILDREN_NODE, "children-data");
//		
//		
//		System.out.println("-----------------------------------------【设置数据】");
//		// 设置数据
//		/**
//		 * 数据watch(data  watches)：getData()和exists()都可以设置数据watch
//		 * 事件状态：【SyncConnected】,事件类型：【NodeDataChanged】，path:/parent-node
//		 */
//		// zk.exists(path, true);// 也可以监听数据变化
//		zk.getData(PARENT_NODE, true, null);
//		watch.setData(PARENT_NODE, "parent-data-change");
//		
//		
//		System.out.println("-----------------------------------------【删除子节点】");
//		// 删除子节点 
//		/**
//		 * 事件状态：【SyncConnected】,事件类型：【NodeDeleted】，path:/parent-node/children-node
//		 * 事件状态：【SyncConnected】,事件类型：【NodeChildrenChanged】，path:/parent-node
//		 */
//		zk.getData(CHILDREN_NODE, true, null);
//		zk.getChildren(PARENT_NODE, true);
//		watch.deleteNodes(CHILDREN_NODE);
//		
//		
//		System.out.println("-----------------------------------------【删除父节点】");
//		// 删除父节点 
//		/**
//		 * 事件状态：【SyncConnected】,事件类型：【NodeDeleted】，path:/parent-node
//		 */
//		zk.exists(PARENT_NODE, true);
//		watch.deleteNodes(PARENT_NODE);
		
		
		
		// 休眠，便于测试
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void setData(String path, String data) {
		try {
			zk.setData(path, data.getBytes(), -1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void deleteAllTestNodes() {
		if (exists(PARENT_NODE) != null) {
			deleteNodes(PARENT_NODE);
		}
		if (exists(CHILDREN_NODE) != null) {
			deleteNodes(CHILDREN_NODE);
		}
	}

	private void deleteNodes(String path) {
		try {
			zk.delete(path, -1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Stat exists(String path) {
		try {
			Stat exists = zk.exists(path, false);
			return exists;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private void createNode(String path, String data) {
		try {
			zk.create(path, data.getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		} catch (KeeperException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void createZookeeper() {
		try {
			zk = new ZooKeeper(CONNECT_ADDR, SESSION_OUTTIME, this);
			latch.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void process(WatchedEvent event) {
		KeeperState state = event.getState();// 状态类型，和客户端实例相关的
		EventType type = event.getType();// 事件类型，znode节点相关的
		String path = event.getPath();// 事件发生的path
		
		if (KeeperState.SyncConnected == state) {// 事件类型为异步连接时
			if (EventType.None == type) {
				latch.countDown();
				System.out.println("事件状态：【"+state+"】,事件类型：【"+type+"】，path:" + path);
			} else if (EventType.NodeCreated == type) {
				System.out.println("事件状态：【"+state+"】,事件类型：【"+type+"】，path:" + path);
			} else if (EventType.NodeDeleted == type) {
				System.out.println("事件状态：【"+state+"】,事件类型：【"+type+"】，path:" + path);
			} else if (EventType.NodeDataChanged == type) {
				System.out.println("事件状态：【"+state+"】,事件类型：【"+type+"】，path:" + path);
			} else if (EventType.NodeChildrenChanged == type) {
				System.out.println("事件状态：【"+state+"】,事件类型：【"+type+"】，path:" + path);
			}
		}
	}

}
