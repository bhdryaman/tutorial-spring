package _01.collection.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import _01.model.Department;
import _01.model.Job;

public class CollectionInjectionTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("01.inject.xml");

		Job personBean = context.getBean("job", Job.class);
		
		System.out.println(personBean);
		
		Department departmentBean = context.getBean("departmentAnnotation", Department.class);
		
		System.out.println(departmentBean);
		
		((ClassPathXmlApplicationContext) context).close();

	}
}
