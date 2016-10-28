package _01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import _01.dao.JobDAO;

@Service(value="jobService")
public class JobService {
	
	@Autowired
	private JobDAO jobDao;

	public JobDAO getJobDao() {
		return jobDao;
	}

	public void setJobDao(JobDAO jobDao) {
		this.jobDao = jobDao;
	}

}
