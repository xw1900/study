package study;

import com.xw.study.spring.aop.bean.MathCalculator;
import com.xw.study.spring.aop.config.MainConfig4Aop;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Timestamp;
import java.util.Date;

public class Demo {

	public static void main(String[] args) {
		Timestamp timestamp = new Timestamp(new Date().getTime());
		
		System.out.println(timestamp instanceof Date);
	}

	@Test
	public void test1() throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig4Aop.class);
		String[] names = context.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println("--》名称:" + name + "--》类型：" + context.getType(name) + "--》地址：" + context.getBean(name));
		}

		MathCalculator calculator = context.getBean(MathCalculator.class);
		calculator.div(2, 0);
		context.close();
	}
}
