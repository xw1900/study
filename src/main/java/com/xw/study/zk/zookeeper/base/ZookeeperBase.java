package com.xw.study.zk.zookeeper.base;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

/**
 * zk的原生api
 * 
 * @author vincent
 *
 */
public class ZookeeperBase {

	// 连接地址
	static String CONNECT_ADDR = "192.168.10.12:2181,192.168.10.13:2181,192.168.10.14:2181";
	// 会话超时时间
	static int SESSION_OUTTIME = 5000;
	
	static CountDownLatch latch = new CountDownLatch(1);

	public static void main(String[] args) throws Exception {
		ZooKeeper zk = new ZooKeeper(CONNECT_ADDR, SESSION_OUTTIME, new Watcher() {

			@Override
			public void process(WatchedEvent event) {
				EventType type = event.getType();
				KeeperState state = event.getState();
				if (KeeperState.SyncConnected == state) {
					if (EventType.None == type) {
						System.out.println("建立连接---");
						latch.countDown();
					}
				}
			}
		});
		latch.await();
		// 创建节点
		zk.create("/xw", "TESTDATA".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		// 获取数据
		System.out.println(new String(zk.getData("/xw", false, null)));
		// 设置数据
		zk.setData("/xw", "TESTDATA1".getBytes(), -1);
		System.out.println(new String(zk.getData("/xw", false, null)));
		// 判断节点是否存在
		System.out.println(zk.exists("/xw", false));
		// 删除节点
		zk.delete("/xw", -1);
		zk.close();
	}

}
