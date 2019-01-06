package com.xw.study.design.pattern.creational._05singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class Test {

	public static void main(String[] args) throws Exception {
//		testSerializable();
		testReflect();
	}

	private static void testReflect() throws Exception {
//		System.out.println(StaticInnerClassSingleton.getInstance());
		
		Class singletonClass = StaticInnerClassSingleton.class;
		Constructor constructor = singletonClass.getDeclaredConstructor();
		constructor.setAccessible(true);
		StaticInnerClassSingleton singleton = (StaticInnerClassSingleton) constructor.newInstance();
		System.out.println(singleton);
	}

	private static void testSerializable() throws Exception {
		StaticInnerClassSingleton instance = StaticInnerClassSingleton.getInstance();
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton"));
		oos.writeObject(instance);
		oos.close();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton"));
		StaticInnerClassSingleton newInstance = (StaticInnerClassSingleton) ois.readObject();
		ois.close();
		System.out.println(instance);
		System.out.println(newInstance);
	}
}
