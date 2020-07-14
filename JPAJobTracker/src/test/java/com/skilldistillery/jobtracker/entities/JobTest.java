package com.skilldistillery.jobtracker.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JobTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Job job;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JobTrackerPU");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		job = em.find(Job.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		job = null;
		em.close();
	}

	@Test
	void test() {
		assertNotNull(job);
		assertEquals("Immersive Wisdom", job.getCompany());
		assertEquals("Software Engineer", job.getTitle());
		assertEquals("Cincinnati", job.getCity());
		assertEquals("OH", job.getState());
		assertEquals("2020-07-13T00:00", job.getDateApplied().toString());
		assertEquals(Status.PENDING, job.getStatus());
		assertEquals(false, job.getCoverLetter());
		assertEquals("Tabatha", job.getUser().getFirstName());
		assertEquals("Flores", job.getUser().getLastName());
		
		
	}

}
