package com.xw.study.spring.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 
 *
 */
@EnableAspectJAutoProxy
@Configuration
@ComponentScan(value={"com.xw.study.spring.aop.bean"})
public class MainConfig4Aop {

}
