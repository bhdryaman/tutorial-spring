package _01.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("employeeIdAnnotation")
public class Employee {
	
	@Value("#{ConfigWithSpel.employeeName}")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + "]";
	}

}
