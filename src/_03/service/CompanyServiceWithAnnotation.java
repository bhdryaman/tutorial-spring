package _03.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import _03.dao.CompanyDAOImplWithAnnotationJPA;


@Service("CompanyServiceWithAnnotation")
public class CompanyServiceWithAnnotation extends AbstractCompanyService {

	//@Autowired
	//@Qualifier("CompanyDAOImplWithAnnotationJPA")
	//private CompanyDAO companyDAOImpl;
	// later with setter method....

	@Autowired
	public CompanyServiceWithAnnotation(CompanyDAOImplWithAnnotationJPA companyDAOImpl) {
		super(companyDAOImpl);
	}

}
