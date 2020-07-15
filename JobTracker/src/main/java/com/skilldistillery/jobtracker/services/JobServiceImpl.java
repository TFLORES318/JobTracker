package com.skilldistillery.jobtracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobtracker.entities.Job;
import com.skilldistillery.jobtracker.entities.Status;
import com.skilldistillery.jobtracker.entities.User;
import com.skilldistillery.jobtracker.repositories.JobRepository;
import com.skilldistillery.jobtracker.repositories.UserRepository;

@Service
public class JobServiceImpl implements JobService {
	
	@Autowired
	private JobRepository jobRepo;
	
	@Autowired 
	private UserRepository userRepo;

	@Override
	public Job show(int jobId, String username) {
		Job job = jobRepo.findByIdAndUserUsername(jobId, username);
		if (job != null) {
			return job;
		}
		return null;
	}
	
	public List<Job> allJobs() {
		return jobRepo.findAll();
	}


	@Override
	public List<Job> allJobsForUser(String username) {
		List<Job> jobs = jobRepo.findByUserUsername(username);
		if (jobs != null) {
			return jobs;
		}
		return null;
	}

	@Override
	public Job createJob(Job job, String username) {
		User user = userRepo.findByUsername(username);
		job.setStatus(Status.PENDING);
		job.setUser(user);
		jobRepo.saveAndFlush(job);
		return job;
	}

	@Override
	public Job updateJob(int jobId, Job job, String username) {
		Job managedJob = jobRepo.findByIdAndUserUsername(jobId, username);
		if (managedJob != null) {
			managedJob.setCompany(job.getCompany());
			managedJob.setTitle(job.getTitle());
			managedJob.setCity(job.getCity());
			managedJob.setState(job.getState());
			managedJob.setNotes(job.getNotes());
			managedJob.setCoverLetter(job.getCoverLetter());
			managedJob.setStatus(job.getStatus());
			jobRepo.saveAndFlush(managedJob);
			return managedJob;
		}
		return null;
	}

	@Override
	public Boolean disable(String username, int jobId) {
		boolean disabledJob = false;
		Job job = jobRepo.findByIdAndUserUsername(jobId, username);
		if (job != null) {
			job.setStatus(Status.REJECTED);
			jobRepo.saveAndFlush(job);
			return !disabledJob;
		}
		return disabledJob;
	}

}
