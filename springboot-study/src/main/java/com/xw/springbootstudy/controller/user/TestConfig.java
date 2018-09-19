package com.xw.springbootstudy.controller.user;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration// @Component一样可以做配置类，但是底层有区别的，@Component不会增强。
@ComponentScan("com.xw.springbootstudy")
public class TestConfig {

}
