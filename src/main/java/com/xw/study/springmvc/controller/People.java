package com.xw.study.springmvc.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class People {

//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Timestamp birth;

	public Timestamp getBirth() {
		return birth;
	}

	public void setBirth(Timestamp birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "People [birth=" + birth + "]";
	}

	
	
	
}
