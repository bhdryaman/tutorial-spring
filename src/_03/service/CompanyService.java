package _03.service;

import java.util.List;

import _03.dao.CompanyDAO;


public class CompanyService extends AbstractCompanyService {

	public CompanyService(CompanyDAO companyDAOImpl) {
		super(companyDAOImpl);
	}

}
