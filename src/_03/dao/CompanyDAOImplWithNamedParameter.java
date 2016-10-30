package _03.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import _03.model.Company;

public class CompanyDAOImplWithNamedParameter implements CompanyDAO {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public static final String SELECT_BYID 	  = "SELECT * FROM company WHERE id = :id";
	public static final String SELECT_ALL 	  = "SELECT * FROM company";
	public static final String INSERT_COMPANY = "INSERT INTO company(id,name) VALUES (:id,:name)";
	public static final String UPDATE_COMPANY = "UPDATE company SET name= :name where id =:id ";
	public static final String DELETE_COMPANY = "DELETE FROM company WHERE id=:id";

	@Override
	public List<Company> getAllCompanies() {

		List<Company> companyList = namedParameterJdbcTemplate.query(SELECT_ALL, new CompanyRowMapper());

		System.out.println("getAllCompanies...");
		for (Company company : companyList) {
			System.out.println(company);
		}

		return companyList;
	}
	
	@Override
	public Company getCompanyById(int id) {

		SqlParameterSource selectParams = new MapSqlParameterSource().addValue("id", id);

		Company company = namedParameterJdbcTemplate.queryForObject(SELECT_BYID, selectParams, new CompanyRowMapper());
		System.out.println("Company is found... : " + company);
		
		return company;
	}
	
	@Override
	public void insert(Company company) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", company.getId());
		params.put("name", company.getName());

		namedParameterJdbcTemplate.update(INSERT_COMPANY, params);
		System.out.println("Company inserted.... : " + company);
		
	}

	@Override
	public void update(Company company) {

		// here used the Class BeanPropertySqlParameterSource for named parameters instead The Map!
		SqlParameterSource params = new BeanPropertySqlParameterSource(company);
		namedParameterJdbcTemplate.update(UPDATE_COMPANY, params);

		System.out.println("Company is updated.... : " + company);

	}

	@Override
	public void delete(int id) {

		// here used the Class MapSqlParameterSource for named parameters instead The Map!
		SqlParameterSource params = new MapSqlParameterSource().addValue("id", id);
		namedParameterJdbcTemplate.update(DELETE_COMPANY, params);
		
		System.out.println("Company is deleted.... : " + id);

	}

}
