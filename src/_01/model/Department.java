package _01.model;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("departmentAnnotation")
public class Department {
	
	private String Name;

	/*
	 * Use the annotation @Resource when injecting the collection
	 * also define the "util:list" in XML file
	 */
	@Resource(name="employeeList")
	private List<String> employeeList;
	
	public Department() {

	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public List<String> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<String> employeeList) {
		this.employeeList = employeeList;
	}

	@Override
	public String toString() {
		return "Department [Name=" + Name + ", employeeList=" + employeeList + "]";
	}

}
