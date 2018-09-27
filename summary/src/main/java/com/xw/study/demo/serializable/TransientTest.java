package com.xw.study.demo.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

public class TransientTest {

	public static void main(String[] args) {

//		testUser();
		testLinkedList();
	}

	private static void testLinkedList() {

//		LinkedList<String> list = new LinkedList<>();
//		list.add("aaa");
//		list.add("bbb");
//		list.add("ccc");
//
//		System.out.println("read before Serializable: ");
//		System.out.println("list: " + list.size());
//
//		try {
//			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("D:/list.txt"));
//			os.writeObject(list); // 将User对象写进文件
//			os.flush();
//			os.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("D:/list.txt"));
			
			// linkedlist中变量有transient修饰，但是同时有重写readObject和writeObject
			LinkedList<String> list2 = (LinkedList<String>) is.readObject(); // 从流中读取User的数据
			is.close();

			System.out.println("\nread after Serializable: ");
			System.out.println("list: " + list2.size());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void testUser() {
		User user = new User();
		user.setUsername("Alexia");
		user.setPasswd("123456");
		user.setAge(18);
		LinkedList<String> list = new LinkedList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		user.setList(list);
		user.setSex(1);

		System.out.println("read before Serializable: ");
		System.out.println("username: " + user.getUsername());
		System.err.println("password: " + user.getPasswd());
		System.out.println("age: " + user.getAge());
		System.out.println("list: " + user.getList().size());
		System.out.println("sex: " + user.getSex());

		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("D:/user.txt"));
			os.writeObject(user); // 将User对象写进文件
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("D:/user.txt"));
			User user2 = (User) is.readObject(); // 从流中读取User的数据
			is.close();

			System.out.println("\nread after Serializable: ");
			System.out.println("username: " + user2.getUsername());
			System.err.println("password: " + user2.getPasswd());
			System.out.println("age: " + user2.getAge());
			System.out.println("list: " + user2.getList().size());
			System.out.println("sex: " + user2.getSex());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

class User implements Serializable {
	private static final long serialVersionUID = 8294180014912103005L;

	private String username;
	private transient String passwd;
	private static Integer age;
	private transient int sex;
	private LinkedList<String> list;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public static Integer getAge() {
		return age;
	}

	public static void setAge(Integer age) {
		User.age = age;
	}

	public LinkedList<String> getList() {
		return list;
	}

	public void setList(LinkedList<String> list) {
		this.list = list;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

}