package com.skilldistillery.jobtracker.services;

import java.util.List;

import com.skilldistillery.jobtracker.entities.Job;

public interface JobService {
	
	List<Job> allJobs();
	
	Job show(int jobId, String username);
	
	List<Job> allJobsForUser(String username);
	
	Job createJob(Job job, String username);
	
	Job updateJob(int jobId, Job job, String username);
	
	Boolean disable(String username, int jobId);
	

}
