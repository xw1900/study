package com.xw.study.data._03queue;

public interface Queue<E> {

	void enqueue(E e);
	E dequeue();
	E getFront();
	int getSize();
	boolean isEmpty();
	
}
