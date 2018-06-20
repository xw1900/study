package com.xw.study.spring.aop.bean;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspects {

	/**
	 * 公共的切入点
	 */
	@Pointcut("execution(public int com.xw.study.spring.aop.bean.MathCalculator.*(..))")
	public void pointCut(){};
	
	@Before(value="pointCut()")
	public void logStart() {
		System.out.println("logStart");
	}
	
	@After(value="pointCut()")
	public void logEnd() {
		System.out.println("logEnd");
	}
	
	@AfterReturning(value="pointCut()")
	public void logReturn() {
		System.out.println("logReturn");
	}
	
	@AfterThrowing(value="pointCut()")
	public void logException() {
		System.out.println("logException");
	}
}
