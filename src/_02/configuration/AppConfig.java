package _02.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import _02.model.Company;

@Configuration
@PropertySource(value = "company.properties")
@ComponentScan(basePackages = "_02.model "
		+ "_02.service "
		+ "_02.awareness")
@ImportResource(value = "02.javabased.xml")
public class AppConfig {

	@Autowired
	Environment env;

	@Bean
	public Company getCompany() {
		int id = Integer.parseInt(env.getProperty("id"));
		String name = env.getProperty("name");
		String address = env.getProperty("address");
		return new Company(id, name, address);
	}

}