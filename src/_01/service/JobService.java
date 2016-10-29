package _01.service;

import javax.inject.Inject;
import javax.inject.Named;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;

import _01.dao.JobDAO;

//@Service(value="jobService")
@Named(value="jobService")
public class JobService {
	
	//@Autowired
	@Inject
	private JobDAO jobDao;

	public JobDAO getJobDao() {
		return jobDao;
	}

	public void setJobDao(JobDAO jobDao) {
		this.jobDao = jobDao;
	}

}
