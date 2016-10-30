package _03.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import _03.model.Company;

public class CompanyDAOImplWithJPA implements CompanyDAO {

	private EntityManager entityManager;

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		entityManager = entityManagerFactory.createEntityManager();
	}

	@Override
	public List<Company> getAllCompanies() {

		TypedQuery<Company> query = entityManager.createQuery("Select e from Company e", Company.class);
		System.out.println("getAllCompanies...");

		return query.getResultList();
	}
	
	@Override
	public Company getCompanyById(int id) {
		
		Company company = entityManager.find(Company.class, id);
		System.out.println("Company is found... : " + company);
		
		return company;

	}

	@Override
	public void insert(Company company) {

		entityManager.getTransaction().begin();
		entityManager.persist(company);
		entityManager.getTransaction().commit();

		System.out.println("Company inserted.... : " + company);
	}
	
	@Override
	public void update(Company company) {

		entityManager.getTransaction().begin();
		entityManager.persist(company);
		entityManager.getTransaction().commit();

		System.out.println("Company updated.... : " + company);
	}

	@Override
	public void delete(int id) {

		entityManager.getTransaction().begin();
		Company company = getCompanyById(id);
		if (company != null) {
			entityManager.remove(company);
		}
		entityManager.getTransaction().commit();
		
		System.out.println("Company is deleted.... : " + company);

	}

}
