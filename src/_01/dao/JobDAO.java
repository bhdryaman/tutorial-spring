package _01.dao;

import org.springframework.stereotype.Repository;

import _01.model.Job;

@Repository
public class JobDAO {

	public void insertEmployee(Job job) {
		System.out.println("Insert....");
	}
	
}
