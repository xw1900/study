package com.xw.study.spring.aop.bean;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAspects {

	/**
	 * 公共的切入点
	 */
	@Pointcut("execution(public int com.xw.study.spring.aop.bean.MathCalculator.*(..))")
	public void pointCut() {
	};

	@Before(value = "pointCut()")
	public void logStart(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		String name = joinPoint.getSignature().getName();
		System.out.println(name + "-->logStart->" + "参数：" + Arrays.asList(args));
	}

	@After(value = "pointCut()")
	public void logEnd(JoinPoint joinPoint) {
		System.out.println("logEnd");
	}

	@AfterReturning(value = "pointCut()", returning = "result")
	public void logReturn(JoinPoint joinPoint, Object result) {
		String name = joinPoint.getSignature().getName();
		System.out.println(name + "-->logReturn" + "-->结果：" + result);
	}

	@AfterThrowing(value = "pointCut()", throwing = "exception")
	public void logException(JoinPoint joinPoint, Exception exception) {
		String name = joinPoint.getSignature().getName();
		System.out.println(name + "-->logException" + "-->异常：" + exception);
	}
	
	@Around(value = "pointCut()")
	public void logAround(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		System.out.println(name + "-->logException");
	}
}
