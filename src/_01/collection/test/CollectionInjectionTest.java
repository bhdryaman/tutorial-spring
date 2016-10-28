package _01.collection.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import _01.model.Company;
import _01.model.Department;
import _01.model.Employee;
import _01.model.Job;
import _01.dao.JobDAO;
import _01.service.JobService;

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
		
		// @Repository
		JobDAO jobDAOBean = context.getBean("jobDAO",JobDAO.class);
		System.out.println(jobDAOBean);
		
		// @Service
		JobService jobServiceBean = context.getBean("jobService",JobService.class);
		System.out.println(jobServiceBean);
		
		((ClassPathXmlApplicationContext) context).close();

	}
}
