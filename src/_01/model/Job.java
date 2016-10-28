package _01.model;

public class Job {
	
	private int id;
	private String type;
	private Company company;
	private String location;
	private String position;
	private boolean isPublic;
	
	public Job(){
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public boolean isPublic() {
		return isPublic;
	}
	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", type=" + type + ", company=" + company + ", location=" + location + ", position="
				+ position + ", isPublic=" + isPublic + "]";
	}

}
