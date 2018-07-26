package com.xw.study.springmvc.service.impl;

import org.springframework.stereotype.Service;

import com.xw.study.springmvc.service.BaseService;
import com.xw.study.springmvc.service.TestService;

@Service
public class TestServiceImpl extends BaseService implements TestService {

	@Override
	public void testPrint(long id) {
		test();
	}

}
