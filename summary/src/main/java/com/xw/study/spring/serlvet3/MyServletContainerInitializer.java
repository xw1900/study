package com.xw.study.spring.serlvet3;
//package com.xw.study.spring.serlvet3;
//
//import java.util.EnumSet;
//import java.util.Set;
//
//import javax.servlet.DispatcherType;
//import javax.servlet.ServletContainerInitializer;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.HandlesTypes;
//
//import com.xw.study.spring.serlvet3.service.HelloService;
//import com.xw.study.spring.serlvet3.servlet.HelloServlet;
//import com.xw.study.spring.serlvet3.servlet.UserFilter;
//import com.xw.study.spring.serlvet3.servlet.UserListener;
//
///**
// * 容器启动的时候会将@HandlesTypes中指定的这个类型的子孙类传递
// */
//@HandlesTypes(value={HelloService.class})
//public class MyServletContainerInitializer implements ServletContainerInitializer {
//
//	@Override
//	public void onStartup(Set<Class<?>> arg0, ServletContext context) throws ServletException {
//		for (Class<?> class1 : arg0) {
//			System.out.println(class1);
//		}
//
////		javax.servlet.ServletRegistration.Dynamic helloServlet = context.addServlet("helloServlet", HelloServlet.class);
////		helloServlet.addMapping("/hello");
////		javax.servlet.FilterRegistration.Dynamic userFilter = context.addFilter("userFilter", UserFilter.class);
////		userFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
//		
//		context.addListener(new UserListener());
//	}
//
//}
