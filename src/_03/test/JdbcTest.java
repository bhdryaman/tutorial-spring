package _03.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import _03.model.Company;
import _03.service.CompanyService;

public class JdbcTest {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("03.jdbc.xml");
		
		// CompanyService compService = context.getBean("companyServiceWithJdbc", CompanyService.class);
		// CompanyService compService = context.getBean("companyServiceWithJdbcTemplate", CompanyService.class);
		// CompanyService compService = context.getBean("companyServiceWithJdbcNamedParameter", CompanyService.class);
		CompanyService compService = context.getBean("companyServiceWithJPA", CompanyService.class);

		compService.delete(1);
		compService.delete(2);

		Company company1 = compService.create(1, "Sony");
		Company company2 = compService.create(2, "Google");

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
		
		company1.setName("PEPSI");
		compService.update(company1);
		
		//compService.delete(1);
		compService.delete(2);
		
	}
}
