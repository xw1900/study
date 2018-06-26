package com.xw.study.spring.other.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.stereotype.Component;

import com.xw.study.spring.other.service.TestService;
import com.xw.study.spring.other.service.impl.TestServiceImpl1;
import com.xw.study.spring.other.service.impl2.TestServiceImpl2;

/**
 * 拓展：
 * 	1、BeanFactoryPostProcessor：BeanFactory的后置处理器
 *		在BeanFactory的标准初始化之后调用，来定制修改BeanFactory的内容
 *		所有的bean定义（已经register了）已经加载到容器中，还未实例化
 *		原理：
 *		1、invokeBeanFactoryPostProcessors(beanFactory);
 *		2、获取到所有的getBeanFactoryPostProcessors()
 *		3、执行PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(beanFactory, getBeanFactoryPostProcessors());
 *		4、BeanDefinitionRegistryPostProcessor extends BeanFactoryPostProcessor
 *		5、	if (postProcessor instanceof BeanDefinitionRegistryPostProcessor) {
 *				registryProcessor.postProcessBeanDefinitionRegistry(registry);
 *				registryProcessors.add(registryProcessor);
 *			}
 *		6、BeanDefinitionRegistryPostProcessor优先于BeanFactoryPostProcessor执行，可以自定义然后往容器中添加组件
 *			spring内部就有这样的组件internalConfigurationAnnotationProcessor=ConfigurationClassPostProcessor
 *			其中就解析我们自定义的组件如扫描包@ComponentScan，@Bean @Import 之类的定义信息都加载进容器，他的优先级最高
 *		7、上面spring内部的BeanDefinitionRegistryPostProcessor执行完后下面再获取了一次，因为我们可能自己定义了被上面第六步加载了进容器
 *			beanFactory.getBeanNamesForType(BeanDefinitionRegistryPostProcessor.class, true, false);
 *		8、还是和第六步一样再按照优先级PriorityOrdered和顺序Ordered执行我们自定义的 BeanFactory后置处理的 postProcessBeanDefinitionRegistry方法
 *		9、此时有可能我们在第八步的后置处理中又加入了自定义的后置处理器，此时会再获取一次，再一次执行
 *		10、最后处理所有的beanFactory的后置处理器的postProcessBeanFactory方法。
 *	注意：public interface BeanDefinitionRegistryPostProcessor extends BeanFactoryPostProcessor {
 *			void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException;
 *		}
 *		也就是说BeanDefinitionRegistryPostProcessor类型的处理器先执行postProcessBeanDefinitionRegistry，最后执行postProcessBeanFactory方法。
 *
 *	2、ApplicationListener
 *		监听ApplicationEvent及其下面的子事件
 *		步骤：
 *			1、public class MyApplicationListener implements ApplicationListener<ApplicationEvent>
 *			2、@Component
 *			3、就可以接受到事件了，如：ContextRefreshedEvent，ContextClosedEvent
 *			4、也可以自己发布事件context.publishEvent(new ApplicationEvent("test") {});
 *		原理：
 *			1、refresh();
 *			2、initApplicationEventMulticaster();
 *			3、拿到所有的监听器，如果没有则创建一个默认的applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
 *			4、registerListeners()
 *			5、
 *
 *
 */
@Configuration
@ComponentScan(value={"com.xw.study.spring.other.listener"})
public class OtherConfig {

	@Bean("testService")
	public TestService testService() {
		return new TestServiceImpl2();
	}
}
