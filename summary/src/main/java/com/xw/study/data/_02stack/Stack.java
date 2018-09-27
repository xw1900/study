package com.xw.study.data._02stack;

public interface Stack<E> {
	
	void push(E e);
	E pop();
	E peek();
	boolean isEmpty();
	int getSize();

}
