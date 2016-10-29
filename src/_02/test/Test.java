package _02.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import _02.configuration.AppConfig;
import _02.model.Company;
import _02.awareness.SpringAwarenessWriter;

public class Test {

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Company employee = ctx.getBean("getCompany",Company.class);

		System.out.println(employee);
		
		SpringAwarenessWriter springAwarenessWriter = ctx.getBean("springAwarenessWriter", SpringAwarenessWriter.class);
		
		springAwarenessWriter.log();
		
		//getInstantiatedSigletons(ctx);
		
		((AnnotationConfigApplicationContext) ctx).close();

	}
	
	 public static List<Object> getInstantiatedSigletons(ApplicationContext ctx) {
		 
         List<Object> singletons = new ArrayList<Object>();

         String[] all = ctx.getBeanDefinitionNames();

         ConfigurableListableBeanFactory clbf = ((AbstractApplicationContext) ctx).getBeanFactory();
         for (String name : all) {
             Object s = clbf.getSingleton(name);
             if (s != null && !name.startsWith("org.springframework")){
                 singletons.add(s);
                 System.out.println("### "+name);
                 System.out.println("\t"+s);
             }
         }
         return singletons;
	 }
	
}
