package com.skilldistillery.jobtracker.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	
	@Column(name="date_applied")
	private LocalDateTime dateApplied;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name="cover_letter")
	private Boolean coverLetter;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Job() {}

	public Job(int id, String company, String title, String city, String state, String notes, LocalDateTime dateApplied,
			Status status, Boolean coverLetter) {
		super();
		this.id = id;
		this.company = company;
		this.title = title;
		this.city = city;
		this.state = state;
		this.notes = notes;
		this.dateApplied = dateApplied;
		this.status = status;
		this.coverLetter = coverLetter;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public LocalDateTime getDateApplied() {
		return dateApplied;
	}

	public void setDateApplied(LocalDateTime dateApplied) {
		this.dateApplied = dateApplied;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Boolean getCoverLetter() {
		return coverLetter;
	}

	public void setCoverLetter(Boolean coverLetter) {
		this.coverLetter = coverLetter;
	}
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", company=" + company + ", title=" + title + ", city=" + city + ", state=" + state
				+ ", notes=" + notes + ", dateApplied=" + dateApplied + ", status=" + status + ", coverLetter="
				+ coverLetter + "]";
	}
	
	
	
	

}
