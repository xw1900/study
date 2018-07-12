package com.xw.study.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

// spring的容器不扫描前端的控件：controller
//@ComponentScan(value = "com.xw.study.springmvc", excludeFilters = {
//		@Filter(type = FilterType.ANNOTATION, value = { Controller.class }) })
//@Configuration
public class RootConfig {

}
