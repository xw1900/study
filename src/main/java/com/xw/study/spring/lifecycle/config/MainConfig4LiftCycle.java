package com.xw.study.spring.lifecycle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xw.study.spring.lifecycle.bean.Car;
import com.xw.study.spring.lifecycle.bean.Cat;
import com.xw.study.spring.lifecycle.bean.MyBeanPostProcessor;

@Configuration
//@ComponentScan(value=("com.xw.study.spring.lifecycle"))
public class MainConfig4LiftCycle {

	/**
	 * bean的生命周期：bean创建（构造方法）->初始化（init）->销毁（destory）
	 * 容器管理bean的生命周期：
	 * 		自定义初始化和销毁方法，容器会在走生命周期的时候调用我们自定义的响应的方法。
	 * 构造：
	 * 		单实例：容器启动的时候创建对象
	 * 		多实例：在每次获取的时候创建对象
	 * 
	 * 初始化init：构造方法之后，可以初始化数据，如连接等
	 * 销毁destory：单实例才会调用，多实例不会调用。在容器销毁之前，可以做我们自定义的工作
	 * 		
	 * 
	 * BeanPostProcessor.postProcessBeforeInitialization：初始化init方法之前执行
	 * 
	 * BeanPostProcessor.postProcessAfterInitialization：初始化init方法之后执行
	 * 
	 * spring会遍历得到容器中所有的BeanPostProcessor，循环，执行postProcessBeforeInitialization
	 * 一旦返回null，跳出循环，不会执行postProcessAfterInitialization
	 * 很多注解都是利用了这个BeanPostProcessor，如@Autowried等，还有awried等
	 * 
	 * 
	 * 1、指定初始化和销毁方法
	 * 		@Bean指定initMethod="init",destroyMethod="detory"
	 * 2、通过让Bean实现InitializingBean（初始化）和DisposableBean（销毁）
	 * 3、使用JSR250，
	 * 		@PostConstruct：在bean创建完成且属性赋值完成后，执行初始化方法
	 * 		@PreDestroy：容器销毁前
	 * 4、BeanPostProcessor：bean的后置处理器
	 * 		在bean初始化前后的处理
	 * 		postProcessBeforeInitialization：初始化init方法之前执行
	 * 		postProcessAfterInitialization：初始化init方法之后执行
	 * 		
	 * @return
	 */
	@Bean
	public Car car() {
		return new Car();
	}
	
	
//	@Bean(initMethod = "init", destroyMethod = "detory")
//	public Car car() {
//		return new Car();
//	}
	
	/**
	 * 按@Bean从上到下的顺序注册
	 */
	@Bean
	public Cat cat() {
		return new Cat();
	}
	
	@Bean
	public MyBeanPostProcessor myBeanPostProcessor() {
		return new MyBeanPostProcessor();
	}
}
