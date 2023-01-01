package com.skilldistillery.jobsearch.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jobsearch.entities.User;

@Service
@Transactional
public class UserDaoImpl implements UserDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public User findById(int userId) {
		return em.find(User.class, userId);
	}

	@Override
	public User login(String username, String password) {
		// TODO make this method check db if there is user with username and password
		// if there is return the user otherwise return null;
		System.out.println("-----------login does not work--------------");
		return null;
	}

	@Override
	public User register(User user) {
		// TODO
		// persist a newly registered user to the database
		System.out.println("-----------register does not work--------------");
		return null;
	}

	@Override
	public boolean isUsernameUnique(String username) {
		// TODO Auto-generated method stub
		// return true if email is unique
		// create jpql query to search for user with username passed in if result set is
		// empty return true
		// else return false
		boolean ans = false;
		String jpql = "select user.username from User user where user.username = :blah";
			List<String> dbUsernames = em.createQuery(jpql, String.class).setParameter("blah", username).getResultList();

			if (dbUsernames.size() < 1) {
				ans = true;
			}

		System.out.println("-----------isUsernameUnique does not work--------------");
		return ans;
	}

	@Override
	public boolean isEmailUnique(String email) {
		// TODO Auto-generated method stub
		/*
		 * return true if email is unique 
		 * create jpql query to search for user with
		 * email passed in if result set is empty return true else return false
		 */

		boolean ans = false;
		String jpql = "select user.email from User user where user.email = :blah";
		
		List<String> dbEmails = em.createQuery(jpql, String.class).setParameter("blah", email).getResultList();
		
		if (dbEmails.size() < 1) {
			ans = true;
		}

		System.out.println("-----------isEmailUnique does not work--------------");
		return ans;
	}

}
