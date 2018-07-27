package com.xw.study.thread.multi003._001;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * List非线程安全
 * @author TTX034
 *
 */
public class Tickets {

	public static void main(String[] args) {
//		ArrayList<String> tickets = new ArrayList();
		Vector<String> tickets = new Vector();
		for (int i = 1; i <= 500; i++) {
			tickets.add("票" + i);
		}
		
		List<Thread> threads = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			threads.add(new Thread("t" + i){
				public void run() {
					while(true){
						if(tickets.isEmpty()){
							break;
						}
						System.out.println("线程：" + Thread.currentThread().getName() + " " + tickets.remove(0));
					}
				};
			});
		}
		for (Thread thread : threads) {
			thread.start();
		}
	}
}
