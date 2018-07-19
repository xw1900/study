package com.xw.study.demo;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {
//		testLocalDateTime();
		testDate();
	}

	private static void testDate() {
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		
		Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
		
		System.out.println(timestamp.getTime());
		System.out.println(timestamp2.getTime());
	}

	private static void testLocalDateTime() {
		Instant in = Instant.now();
		System.out.println(in);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime time = LocalDateTime.now();
		System.out.println(time.format(formatter));

		Date date = new Date();
		System.out.println(date);
	}
}
