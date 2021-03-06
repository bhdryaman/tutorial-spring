package _03.test;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import _03.model.Company;
import _03.service.AbstractCompanyService;
import _03.service.CompanyServiceWithAnnotation;

public class DbTest {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("03.db.xml");
		
		// AbstractCompanyService compService = context.getBean("companyServiceWithJdbc", CompanyService.class);
		// AbstractCompanyService compService = context.getBean("companyServiceWithJdbcTemplate", CompanyService.class);
		// AbstractCompanyService compService = context.getBean("companyServiceWithJdbcNamedParameter", CompanyService.class);
		// AbstractCompanyService compService = context.getBean("companyServiceWithJPA", CompanyService.class);
		AbstractCompanyService compService = context.getBean("CompanyServiceWithAnnotation", CompanyServiceWithAnnotation.class);

		compService.delete(1);
		compService.delete(2);

		Company company1 = compService.create(1, "Sony");
		Company company2 = compService.create(2, "Samsung");

		compService.insert(company1);
		compService.insert(company2);

		Company company3 = compService.get(1);
		
		System.out.println("company1 : "+company1);
		System.out.println("company3 : "+company3);
		System.out.println("company1 == company3 : " + (company1 == company3));
		
		List<Company> all = compService.getAll();
		
		for(Company item : all){
			System.out.println(item);
		}
		
		company1.setName("Apple");
		compService.update(company1);
		
		//compService.delete(1);
		compService.delete(2);
		
		((ClassPathXmlApplicationContext) context).close();
		
	}
}
