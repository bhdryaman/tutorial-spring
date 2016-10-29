package _02.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import _02.configuration.AppConfig;
import _02.model.BeanCreationLifecycleWriter;
import _02.model.BeanDestructionLifecycleWriter;

public class LifeCycleTest {

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		BeanCreationLifecycleWriter bean = ctx.getBean("lifecycleCreation", BeanCreationLifecycleWriter.class);
		
		System.out.println(bean);
		
		BeanDestructionLifecycleWriter beanDestruction = ctx.getBean("lifecycleDestruction", BeanDestructionLifecycleWriter.class);

		System.out.println(beanDestruction);
		
		((AnnotationConfigApplicationContext) ctx).close();

	}
	
}
