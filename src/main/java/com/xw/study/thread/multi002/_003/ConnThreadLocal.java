package com.xw.study.thread.multi002._003;

/**
 * ThreadLocal在每个线程中对该变量会创建一个副本，即每个线程内部都会有一个该变量
 * 使用场景：如数据库连接，hibernate就用到了这个
 * 还有如写接口时每次请求（每个线程）都要根据当前请求保存当前请求的一些数据
 * （如根据请求的参数或者域名查数据，这些数据需要在整个请求中都用到）
 * 还有如在整个请求中携带个人信息，以便后续在业务层或dao中用到，就不需要每次都往下传。。。
 * 
 * threadlocal结构：一个线程有一个ThreadLocalMap，
 * map中可以存放多个threadlocal，map的key是threadlocal，值是需要设置的value
 * 每个线程中可有多个threadLocal变量
 * @author TTX034
 *
 */
public class ConnThreadLocal {

	private ThreadLocal<String> tl = new ThreadLocal<>();
	
	public void setValue(String value){
		tl.set(value);
	}
	
	public String getValue(){
		return tl.get();
	}
	
	public static void main(String[] args) {
		
		ConnThreadLocal local = new ConnThreadLocal();
		
		Thread thread1 = new Thread("t1"){
			public void run() {
				local.setValue("张三");
				System.out.println("线程：" + Thread.currentThread().getName() + " " + local.getValue());
			};
		};
		Thread thread2 = new Thread("t2"){
			public void run() {
				local.setValue("李四");
				System.out.println("线程：" + Thread.currentThread().getName() + " " + local.getValue());
			};
		};
		
		System.out.println("线程：" + Thread.currentThread().getName() + " " + local.getValue());
		thread1.start();
		thread2.start();
	}
}
