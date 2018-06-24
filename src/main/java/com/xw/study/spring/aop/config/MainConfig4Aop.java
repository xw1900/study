package com.xw.study.spring.aop.config;

import java.util.ArrayList;
import java.util.List;

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.xw.study.spring.aop.bean.LogAspects;
import com.xw.study.spring.aop.bean.MathCalculator;

/**
 * AOP:在程序运行期间动态的将某段代码切入到指定方法的指定位置进行运行的编程方式
 * 
 * 1、导入aop模块 spring-aspects
 * 2、定义一个业务类，MathCalculator，需要切入的
 * 3、日志切面类，切入进去后 定义处理逻辑
 * 	通知方法：
 * 		前置通知：@Before，在目标方法运行前执行
 * 		后置通知：@After，在目标方法运行后执行
 * 		返回通知：@AfterReturning，在目标方法正常放回后执行
 * 		异常通知：@AfterThrowing，在目标方法运行时出现异常时执行
 * 		环绕通知：@Around
 * 4、给切面类的目标方法标注何时何地执行（@Pointcut）
 * 5、将切面类和业务类都加入到容器中@Component（需扫描包），@Bean
 * 6、标记切面类：@Aspect
 * 7、开启基于注解的aop模式：@EnableAspectJAutoProxy
 * 		实际上是：@Import(AspectJAutoProxyRegistrar.class)
 * 		@Enablexxx:spring中很多这种，都是用了@Import，将某个bean注册进容器中。
 * 			如：	@EnableTransactionManagement：开启spring事务管理
 *				@EnableCaching：开启spring缓存
 *				@EnableWebMvc：开启webMvc
 * 
 * AOP原理：
 * 	@Import(AspectJAutoProxyRegistrar.class)
 * 		AspectJAutoProxyRegistrar implements ImportBeanDefinitionRegistrar
 * 		实际上注册了一个bean，如下：且order=Integer.MIN_VALUE
 * 			internalAutoProxyCreator=AnnotationAwareAspectJAutoProxyCreator，
 * 
 * 	继承关系：
 * 	AnnotationAwareAspectJAutoProxyCreator
 * 		AspectJAwareAdvisorAutoProxyCreator
 * 			AbstractAdvisorAutoProxyCreator
 * 				AbstractAutoProxyCreator
 *					实现：SmartInstantiationAwareBeanPostProcessor，BeanFactoryAware
 *							InstantiationAwareBeanPostProcessor
 *								BeanPostProcessor
 *	所以实际上是一个后置处理器：后置处理器一般是  实例化后，对应的属性注入等还没有进行，且是在初始化前  执行，注意：此处例外
 *	且实现了BeanFactoryAware
 *	
 *	整体流程：
 *		1、用MainConfig4Aop配置类，初始化ioc容器，调用refresh();
 *		2、registerBeanPostProcessors(beanFactory);注册后置处理器
 *			1、获取容器中所有的已定义的BeanPostProcessor，(register(annotatedClasses)中定义的)
 *				beanFactory.getBeanNamesForType(BeanPostProcessor.class, true, false);
 *			2、对BeanPostProcessor排序
 *				1、将实现了PriorityOrdered（优先排序的）接口的放到一个集合中
 *				2、将实现了Ordered接口的放到一个集合中
 *				3、不排序的放到一个一个集合中
 *			3、排序后注册到容器中（就是调用beanFactory.getBean(ppName, BeanPostProcessor.class)创建bean，然后保存到容器中）
 *				1、将存放PriorityOrdered集合的list排序，然后将集合中的bean实例化注册进容器中
 *				2、将存放Ordered集合的list排序，然后将集合中的bean实例化注册进容器中
 *				3、将其他的排序实例化，注册进容器中
 *				实例化过程：beanFactory.getBean(ppName, BeanPostProcessor.class);
 *					--》创建实例：instanceWrapper = createBeanInstance(beanName, mbd, args);
 *					--》参数赋值：populateBean(beanName, mbd, instanceWrapper);
 *					--》初始化bean：initializeBean(beanName, exposedObject, mbd);
 *					--》处理aware赋值，invokeAwareMethods(beanName, bean);
 *					--》初始化前处理：applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
 *					--》初始化：invokeInitMethods(beanName, wrappedBean, mbd);
 *					--》初始化后处理：applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
 *					
 *		3、finishBeanFactoryInitialization
 *			1、实例化剩下的bean（其他我们自定义的bean）beanFactory.preInstantiateSingletons();
 *				1、List<String> beanNames = new ArrayList<String>(this.beanDefinitionNames);
					遍历获取所有的bean，依次创建对象 for (String beanName : beanNames)
				2、getBean(beanName);
				3、createBean(beanName, mbd, args);
				4、resolveBeforeInstantiation(beanName, mbdToUse);给后置处理器一个机会以便可以返回一个代理而不是目标实例化对象
					这个方法在之前注册后置处理器的时候也有，只是那个时候容器中还没有后置处理器的实例对象，只有定义。
					1、applyBeanPostProcessorsBeforeInstantiation(targetType, beanName);
						1、遍历所有的后置处理器
						2、如果后置处理器是InstantiationAwareBeanPostProcessor这种类型
						3、则执行后置处理器的postProcessBeforeInstantiation方法。
						4、postProcessBeforeInstantiation执行完后不为null则执行后置处理器的postProcessAfterInitialization方法。
				5、doCreateBean(beanName, mbdToUse, args);
					和之前注册后置处理器的逻辑一致。
		4、分析上面3.1.4.1.3，也就是InstantiationAwareBeanPostProcessor的后置方法
			1、aop之前注册了AnnotationAwareAspectJAutoProxyCreator
			2、AnnotationAwareAspectJAutoProxyCreator就是InstantiationAwareBeanPostProcessor类型
				所以并不是所有的后置处理器都是在对象实例化后初始化前执行。
			3、判断当前bean是否在advisedBeans中（存放需要增强的bean）
			4、isInfrastructureClass(beanClass) 判断当前bean是否是Advice Pointcut Advisor AopInfrastructureBean类型，或者标有Aspect注解，或者是否需要跳过
				shouldSkip(beanClass, beanName) 是否需要跳过，
					1、findCandidateAdvisors(); 获取候选的增强器（就是aspect中的通知方法）
					【包装成了List<Advisor> candidateAdvisors，类型：InstantiationModelAwarePointcutAdvisor】
			5、MathCalculator只是一个普通的bean，显然不是增强器，返回null，不会执行3.1.4.1.4的postProcessAfterInitialization
				但是但是但是，只是不会执行resolveBeforeInstantiation中的postProcessAfterInitialization
				还是会执行正常流程的postProcessAfterInitialization方法
				所以MathCalculator和3.1.4 resolveBeforeInstantiation没有什么关系
				不需要给后置处理器一个机会以便可以返回一个代理而不是目标实例化对象，LogAspects才需要
				然后继续执行3.1.4.1.5的创建bean流程，其中会执行正常流程的postProcessAfterInitialization方法，如下：
		5、正常流程的postProcessAfterInitialization
			MathCalculator初始化后执行以下流程
			1、return wrapIfNecessary(bean, beanName, cacheKey);
			2、getAdvicesAndAdvisorsForBean(bean.getClass(), beanName, null);获取bean的增强器
			3、findEligibleAdvisors(beanClass, beanName);获取能在当前bean中使用的增强器
			4、给通知方法排序
			5、保存到增强处理bean中 advisedBeans.put(cacheKey, Boolean.TRUE);
			6、createProxy 创建代理对象
				1、生成proxyFactory，存放有需要增强的bean以及增强器
				2、proxyFactory.getProxy(getProxyClassLoader());生成代理
					1、如果是接口则创建jdk的，不是则cglib
						if (targetClass.isInterface() || Proxy.isProxyClass(targetClass)) {
							return new JdkDynamicAopProxy(config);
						}
						return new ObjenesisCglibAopProxy(config);
				3、容器中存放的就是代理对象，代理对象中存放着目标方法，通知方法等
				
		6、目标方法的执行
			1、拦截目标方法执行 CglibAopProxy.intercept
			2、获取目标方法的拦截器链 getInterceptorsAndDynamicInterceptionAdvice(method, targetClass);
				1、List<Object> interceptorList = new ArrayList<Object>(config.getAdvisors().length);
				2、遍历所有的增强器（通知方法），封装成Interceptor对象放到interceptorList 
					registry.getInterceptors(advisor);
					1、判断是不是MethodInterceptor，是则直接加，不是就用适配器转换
			3、如果没有拦截器链，直接执行目标方法 methodProxy.invoke(target, argsToUse);
			4、有拦截器链，CglibMethodInvocation.proceed();
			
		7、拦截器链的调用过程 CglibMethodInvocation.proceed();
			1、	if (this.currentInterceptorIndex == this.interceptorsAndDynamicMethodMatchers.size() - 1) {
					return invokeJoinpoint();
				}
				currentInterceptorIndex初始是-1
				interceptorsAndDynamicMethodMatchers是拦截器链
				如果拦截器链是空的：则正好相等，则直接通过反射执行目标方法，method.invoke(target, args);不执行增强通知方法。
				如果是最后一个：也相等，此时相当于通知方法已经执行完了，也去执行目标方法
			2、((MethodInterceptor) interceptorOrInterceptionAdvice).invoke(this);
			3、第一个拦截器是执行ExposeInvocationInterceptor.invoke
			4、return mi.proceed();还是执行proceed()方法
			5、第二个拦截器则是相应的通知方法的invode()方法，还是会执行proceed()方法
			6、第三个拦截器则是相应的通知方法的invode()方法，还是会执行proceed()方法，依次执行...
			7、一直执行到最后一个拦截器前，都还没有处理任何和我们写的相关的代码，直到最后一个
			8、最后一个拦截器是before的（如果有的话）所以很重要的是拦截器链是排好序的，先before执行，然后目标方法，然后aftet或者异常，这很重要
			9、还有很重要的是不同的通知方法的拦截器不同
			10、执行到before的拦截器，先会调用前置通知，然后再执行proceed()
			11、此时已经是最后一个了，则会执行第一个提到的 return invokeJoinpoint();反射执行目标方法
			12、return invokeJoinpoint();之后，因为是一层一层调用的，before return会到目标方法，目标方法return会到after
			13、每个通知方法都会try，throw的通知方法才会catch，如果有异常则会走throw，没有则会afterreturn，
			14、然后再一层层返回，最终执行完毕
			
 *				
 */								
@EnableAspectJAutoProxy
@Configuration
@ComponentScan(value={"com.xw.study.spring.aop.bean"})
public class MainConfig4Aop {

	@Bean
	public MathCalculator mathCalculator() {
		return new MathCalculator();
	}
	
	@Bean
	public LogAspects logAspects() {
		return new LogAspects();
	}
}
