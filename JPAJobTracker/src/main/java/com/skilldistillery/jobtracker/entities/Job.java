package com.skilldistillery.jobtracker.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String company;
	private String title;
	private String city;
	private String state;
	private String notes;
	private LocalDateTime dateApplied;
	private Status status;
	

}
