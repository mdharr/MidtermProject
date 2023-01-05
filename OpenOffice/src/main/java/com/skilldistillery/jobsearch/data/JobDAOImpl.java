package com.skilldistillery.jobsearch.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jobsearch.entities.Job;

@Service
@Transactional
public class JobDAOImpl implements JobDAO{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Job> findAllJobs() {
		String jpql = "SELECT job FROM Job job";
		return em.createQuery(jpql, Job.class).getResultList();
	}
	@Override
	public List<Job> findJobs(String title) {

		List<Job> ans = new ArrayList<>();
		String jpql = "select job from Job job where job.title like :title";

		ans = em.createQuery(jpql, Job.class).setParameter("title", "%" + title + "%").getResultList();
		return ans;

	}
	@Override
	public Job findJobById(Integer jobId) {
		return em.find(Job.class, jobId);
	}
	
}


