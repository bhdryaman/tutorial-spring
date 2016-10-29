package _02.model;

//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;

//@Component("companyId")
public class Company {

	private int id;
	
	//@Value("testname")
	private String name;
	
	//@Value("testaddress")
	private String address;
	
	public Company(){
		
	}

	public Company(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
}
