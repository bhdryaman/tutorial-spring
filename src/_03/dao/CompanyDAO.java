package _03.dao;

import java.util.List;

import _03.model.Company;

public interface CompanyDAO {

	public List<Company> getAllCompanies();
	public Company getCompanyById(int id);
	public void insert(Company company);
	public void update(Company company);
	public void delete(int id);

}
