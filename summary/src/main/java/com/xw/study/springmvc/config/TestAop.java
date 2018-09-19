package com.xw.study.springmvc.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAop {

	@Pointcut("execution(* com.xw.study.springmvc.controller..*.*(..))")
	private void testPointCut() {
	}

	@Before("testPointCut()")
	private void deBefore() throws Throwable {
		System.out.println("---------testaop--------");
	}
}
