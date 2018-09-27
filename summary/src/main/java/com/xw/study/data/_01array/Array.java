package com.xw.study.data._01array;

public class Array<E> {

	private Object[] data;
	private int size;

	public Array(int capacity) {
		data = new Object[capacity];
		size = 0;
	}

	public Array() {
		this(10);
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int getCapacity() {
		return data.length;
	}

	public void addFirst(E e) {
		add(0, e);
	}

	public void addLast(E e) {
		add(size, e);
	}

	public void add(int index, E e) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("添加元素索引不能<0且不能大于当前长度！");
		}
//		if (index == data.length) {
//			throw new IllegalArgumentException("数组已满！");
//		}
		
		// 动态扩容
		if (size == data.length) {
			resize(size * 2);
		}
		
		for (int i = size - 1; i >= index; i--) {
			data[i + 1] = data[i];
		}

		data[index] = e;
		size++;
	}

	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("参数异常！");
		}
		return (E) data[index];
	}
	
	public E getLast() {
		return get(size - 1);
	}
	
	public E getFirst() {
		return get(0);
	}

	public void set(int index, E e) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("参数异常！");
		}
		data[index] = e;
	}

	public boolean contains(E e) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e)) {
				return true;
			}
		}
		return false;
	}

	public int find(E e) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}
	
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("所删除元素索引不能<0且不能大于当前最大长度！");
		}
		
		E current = (E) data[index];
		data[index] = null;
		for (int i = index; i < size - 1; i++) {
			data[i] = data[i + 1];
		}
		
		size --;
		
		// 动态缩容
		if (size == data.length / 4) {
			resize(data.length / 2);
		}
		return current;
	}
	
	private void resize(int newSize) {
		Object[] newData = new Object[newSize];
		for (int i = 0; i < size; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}
	
	public E removeFirst() {
		return remove(0);
	}
	
	public E removeLast() {
		return remove(size -1);
	}
	
	public boolean removeElement(E e) {
		int index = find(e);
		if (index != -1) {
			remove(index);
			return true;
		}
		return false;
	}

	@Override
	public String toString() {

		StringBuilder res = new StringBuilder();
		res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
		res.append('[');
		for (int i = 0; i < size; i++) {
			res.append(data[i]);
			if (i != size - 1)
				res.append(", ");
		}
		res.append(']');
		return res.toString();
	}
}
