package _01.collection.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import _01.model.Company;
import _01.model.Department;
import _01.model.Employee;
import _01.model.Job;

public class CollectionInjectionTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("01.inject.xml");

		Job personBean = context.getBean("job", Job.class);
		System.out.println(personBean);
		
		Department departmentBean = context.getBean("departmentAnnotation", Department.class);
		System.out.println(departmentBean);
		
		Company companyBean = context.getBean("company3", Company.class);
		System.out.println(companyBean);
		
		Employee employeeBean = context.getBean("employeeIdAnnotation", Employee.class);
		System.out.println(employeeBean);
		
		((ClassPathXmlApplicationContext) context).close();

	}
}
