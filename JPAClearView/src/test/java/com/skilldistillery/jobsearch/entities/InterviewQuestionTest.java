package com.skilldistillery.jobsearch.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InterviewQuestionTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private InterviewQuestion interview;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	emf = Persistence.createEntityManagerFactory("JPAOpenOffice");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		interview = em.find(InterviewQuestion.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}

	@Test
	void test_interview_basic_mappings() {
		assertNotNull(interview);
		assertEquals(1, interview.getId());
		assertEquals("Two Sum", interview.getTitle());
		assertEquals("Two Sum", interview.getName());
	}
	
	@Test
	void test_Interview_InterveiwQuestion_many_to_many_mapping() {
		assertNotNull(interview);
		assertTrue(interview.getInterviews().size() > 0);
	}

}
