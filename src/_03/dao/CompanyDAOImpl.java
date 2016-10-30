package _03.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import _03.model.Company;

public class CompanyDAOImpl implements CompanyDAO {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public static final String SELECT_BYID 	  = "SELECT * FROM company WHERE id = ?";
	public static final String SELECT_ALL 	  = "SELECT * FROM company";
	public static final String INSERT_COMPANY = "INSERT INTO company(id,name) VALUES (?,?)";
	public static final String UPDATE_COMPANY = "UPDATE company SET name= ? where id =? ";
	public static final String DELETE_COMPANY = "DELETE FROM company WHERE id=?";

	@Override
	public List<Company> getAllCompanies() {
		
		Connection connection = getConnection();
		PreparedStatement ps = null;
		Company company = null;
		List<Company> companyList = new ArrayList<Company>();
		try {
			ps = connection.prepareStatement(SELECT_ALL);

			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				company = new Company(id, name);

				companyList.add(company);
			}

			System.out.println("getAllCompanys...");

			if (companyList != null) {
				for (Company p : companyList) {
					System.out.println(p);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return companyList;

	}
	
	@Override
	public Company getCompanyById(int id) {

		Connection connection = getConnection();
		PreparedStatement ps = null;
		Company company = null;
		try {
			ps = connection.prepareStatement(SELECT_BYID);
			ps.setInt(1, id);

			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				String name = resultSet.getString("name");
				company = new Company(id, name);
				System.out.println("Company is found... : "+company);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return company;

	}

	@Override
	public void insert(Company company) {

		Connection connection = getConnection();
		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement(INSERT_COMPANY);
			ps.setInt(1, company.getId());
			ps.setString(2, company.getName());

			ps.executeUpdate();
			ps.close();

			System.out.println("Company inserted.... : "+company);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Company company) {

		Connection connection = getConnection();
		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement(UPDATE_COMPANY);
			ps.setString(1, company.getName());
			ps.setInt(2, company.getId());

			ps.executeUpdate();
			ps.close();

			System.out.println("Company is updated.... : " + company);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {

		Connection connection = getConnection();
		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement(DELETE_COMPANY);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
