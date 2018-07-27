package com.xw.study.thread.multi001._007;

/**
 * 子线程在运行时会将值copy一份到线程内部使用，其他线程改变了这个值 不会立即被使用到。
 * volatile 多线程内改的值会立即同步到 主内存 中
 * @author TTX034
 *
 */
public class RunThread extends Thread {

	private boolean isRunning = true;
	
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	@Override
	public void run() {
		while(isRunning == true) {
			
		}
		System.out.println("线程停止！");
	}
	
	public static void main(String[] args) {
		RunThread thread = new RunThread();
		thread.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread.setRunning(false);
		System.out.println("设置完成！");
		
		
	}
}
