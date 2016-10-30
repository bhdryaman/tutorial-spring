package _03.service;

import java.util.List;

import _03.dao.CompanyDAO;
import _03.model.Company;

public class CompanyService {

	private CompanyDAO companyDAOImpl;

	public CompanyService(CompanyDAO companyDAOImpl) {
		super();
		this.companyDAOImpl = companyDAOImpl;
	}

	public Company get(int id) {
		return companyDAOImpl.getCompanyById(id);
	}

	public List<Company> getAll() {
		return companyDAOImpl.getAllCompanies();
	}
	
	public Company create(int id, String name) {
		return new Company(id, name);
	}

	public void insert(Company company) {
		companyDAOImpl.insert(company);
	}
	
	public void update(Company company) {
		companyDAOImpl.update(company);
	}

	public void delete(int id) {
		companyDAOImpl.delete(id);
	}

}
