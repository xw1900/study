package com.xw.study.spring.register.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

import com.xw.study.spring.register.bean.PeopleFactoryBean;
import com.xw.study.spring.register.bean.Person;
import com.xw.study.spring.register.condition.LinuxCondition;
import com.xw.study.spring.register.condition.WindowsCondition;
import com.xw.study.spring.register.importt.MyImportBeanDefinitionRegistrar;

//放到类上代表满足条件这个类的bean才会注册，方法上仍然可以加，多一层条件过滤
@Conditional({WindowsCondition.class})
@Configuration
//@Import(value={Red.class})// @Import注解默认是注册的组件的全类名
//@Import(value={MyImportSelector.class})
@Import(value={MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {

	/**
	 * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE 多实例，获取才会创建对象，但是还是会将该bean扫描到容器中去（名称，类型都有），只是没有实例化而已
	 * @see ConfigurableBeanFactory#SCOPE_SINGLETON 默认单实例，启动就会创建对象放到ioc容器中
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST 同一请求
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION 同一session
	 * 
	 */
//	@Scope(value="prototype")
	@Lazy
	@Bean
	public Person person02() {
		System.out.println("给容器中添加Person....");
		return new Person("李四", 20);
	}
	
	/**
	 * @Conditional(value=WindowsCondition.class) 编写条件，满足才注册到容器中
	 */
	@Conditional(value=WindowsCondition.class)
	@Bean(value="bill")
	public Person billlll() {
		return new Person("bill", 66);
	}
	
	@Conditional(value=LinuxCondition.class)
	@Bean(value="linus")
	public Person linusss() {
		return new Person("linux", 55);
	}
	
	
	/**
	 * 给容器中注册组件；
	 * 1）、包扫描+组件标注注解（@Controller/@Service/@Repository/@Component）[自己写的类]
	 * 2）、@Bean[导入的第三方包里面的组件]
	 * 3）、@Import[快速给容器中导入一个组件]
	 * 		1）、@Import(要导入到容器中的组件)；容器中就会自动注册这个组件，id默认是全类名
	 * 		2）、ImportSelector:返回需要导入的组件的全类名数组；
	 * 		3）、ImportBeanDefinitionRegistrar:手动注册bean到容器中
	 * 4）、使用Spring提供的 FactoryBean（工厂Bean）;
	 * 		1）、默认获取到的是工厂bean调用getObject创建的对象
	 * 		2）、要获取工厂Bean本身，我们需要给id前面加一个&
	 * 			&colorFactoryBean
	 */
	@Bean
	public PeopleFactoryBean peopleFactoryBean() {
		return new PeopleFactoryBean();
	}
}
