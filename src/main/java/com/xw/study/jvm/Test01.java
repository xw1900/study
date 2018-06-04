package com.xw.study.jvm;

/**
 * JVM初始分配的内存由-Xms指定，默认是物理内存的1/64；JVM最大分配的内存由-Xmx指定，默认是物理内存的1/4
	新生代收集器：都是使用复制算法
		Serial收集器：使用一个线程进行GC，串行，其它工作线程暂停。
		ParNew收集器：Serial收集器的多线程版，用多个线程进行GC，并行，其它工作线程暂停。使用-XX:+UseParNewGC开关来控制使用ParNew+Serial Old收集器组合收集内存；使用-XX:ParallelGCThreads来设置执行内存回收的线程数。
		Parallel Scavenge ：吞吐量优先的垃圾回收器，关注CPU吞吐量，即运行用户代码的时间/总时间。使用-XX:+UseParallelGC开关控制使用Parallel Scavenge+Serial Old收集器组合回收垃圾。
	老年代收集器：
		Serial Old收集器：使用标记整理算法，单线程，串行，使用单线程进行GC，其它工作线程暂停。
		Parallel Old收集器：使用标记整理算法，多线程，吞吐量优先的垃圾回收器，并行，多线程机制与Parallel Scavenge差不错，在Parallel Old执行时，仍然需要暂停其它线程。
		CMS（Concurrent Mark Sweep）：使用标记清除算法，多线程，致力于获取最短回收停顿时间（即缩短垃圾回收的时间），优点是并发收集（用户线程可以和GC线程同时工作），停顿小。使用-XX:+UseConcMarkSweepGC进行ParNew+CMS+Serial Old进行内存回收，优先使用ParNew+CMS，当用户线程内存不足时，采用备用方案Serial Old收集。
 * @author TTX034
 *
 */
public class Test01 {

	public static void main(String[] args) {

		//-Xms5m -Xmx20m -XX:+PrintGCDetails -XX:+UseSerialGC -XX:+PrintCommandLineFlags
		/**
		 * -Xms5m：堆内存
		 */
		System.out.println("计算得到的默认初始内存:" + 12*1024/64);
		System.out.println("计算得到的默认初始内存:" + 12*1024/4);
		
		//查看GC信息
		System.out.println("max memory:" + Runtime.getRuntime().maxMemory()/1024/1024);
		System.out.println("free memory:" + Runtime.getRuntime().freeMemory()/1024/1024);
		System.out.println("total memory:" + Runtime.getRuntime().totalMemory()/1024/1024);
		
		byte[] b1 = new byte[1*1024*1024];
		System.out.println("分配了1M");
		System.out.println("max memory:" + Runtime.getRuntime().maxMemory()/1024/1024);
		System.out.println("free memory:" + Runtime.getRuntime().freeMemory()/1024/1024);
		System.out.println("total memory:" + Runtime.getRuntime().totalMemory()/1024/1024);
		
		byte[] b2 = new byte[4*1024*1024];
		System.out.println("分配了4M");
		System.out.println("max memory:" + Runtime.getRuntime().maxMemory()/1024/1024);
		System.out.println("free memory:" + Runtime.getRuntime().freeMemory()/1024/1024);
		System.out.println("total memory:" + Runtime.getRuntime().totalMemory()/1024/1024);
		
	}
	
}
