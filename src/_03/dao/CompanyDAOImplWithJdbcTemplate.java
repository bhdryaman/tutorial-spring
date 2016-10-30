package _03.dao;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import _03.model.Company;

public class CompanyDAOImplWithJdbcTemplate implements CompanyDAO {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public static final String SELECT_BYID 	  = "SELECT * FROM company WHERE id = ?";
	public static final String SELECT_ALL 	  = "SELECT * FROM company";
	public static final String INSERT_COMPANY = "INSERT INTO company(id,name) VALUES (?,?)";
	public static final String UPDATE_COMPANY = "UPDATE company SET name= ? where id =? ";
	public static final String DELETE_COMPANY = "DELETE FROM company WHERE id=?";

	@Override
	public List<Company> getAllCompanies() {

		List<Company> companyList = jdbcTemplate.query(SELECT_ALL, new CompanyRowMapper());
		System.out.println("getAllCompanies...");
		for (Company company : companyList) {
			System.out.println(company);
		}
		return companyList;

	}
	
	@Override
	public Company getCompanyById(int id) {

		Object[] selectParams = new Object[]{id};
		Company company = jdbcTemplate.queryForObject(SELECT_BYID, selectParams, new CompanyRowMapper());
		System.out.println("Company is found... : "+company);
		return company;

	}
	
	@Override
	public void insert(Company company) {

		Object[] insertParameters = new Object[]{company.getId(), company.getName()};
		jdbcTemplate.update(INSERT_COMPANY, insertParameters);
		System.out.println("Company inserted.... : "+company);

	}
	
	@Override
	public void update(Company company) {

		Object[] updateParameters = new Object[]{company.getId(), company.getName()};
		jdbcTemplate.update(UPDATE_COMPANY, updateParameters);
		System.out.println("Company is updated.... : " + company);

	}

	@Override
	public void delete(int id) {

		jdbcTemplate.update(DELETE_COMPANY, id);
		System.out.println("Company is deleted.... : " + id);

	}

}
