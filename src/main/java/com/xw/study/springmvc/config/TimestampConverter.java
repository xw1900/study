package com.xw.study.springmvc.config;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

public class TimestampConverter implements Converter<String, Timestamp> {

	@Override
	public Timestamp convert(String text) {
		if (!StringUtils.isEmpty(text)) {
//			Timestamp timestamp = Timestamp.valueOf(text);
			return new Timestamp(new Date().getTime());
		}
		return new Timestamp(new Date().getTime());
	}

}