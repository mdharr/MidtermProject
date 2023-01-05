package com.skilldistillery.jobsearch.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.jobsearch.entities.Company;
import com.skilldistillery.jobsearch.entities.CompanyReview;
import com.skilldistillery.jobsearch.entities.User;

@Service
@Transactional
public class CompanyReviewDAOImpl implements CompanyReviewDAO {
	@PersistenceContext
	private EntityManager em;

	@Override
	public User findById(int userId) {
		return em.find(User.class, userId);
	}

	@Override
	public Company findCompanyById(Integer companyId) {
		return em.find(Company.class, companyId);
	}

	@Override
	public CompanyReview create(CompanyReview companyReview) {
		CompanyReview review = null;
		int userId = companyReview.getUser().getId();
		User user = findById(userId);
		int companyId = companyReview.getCompany().getId();
		Company company = findCompanyById(companyId);

		if (user != null && company != null) {
			review = new CompanyReview();
			em.persist(companyReview);
		}
		return companyReview;
	}

	@Override
	public CompanyReview updateCompanyReview(int companyId, CompanyReview companyReview) {

		CompanyReview reviewUpdate = em.find(CompanyReview.class, companyId);

		reviewUpdate.setTitle(companyReview.getTitle());
		reviewUpdate.setContent(companyReview.getContent());
		reviewUpdate.setRating(companyReview.getRating());
		reviewUpdate.setPros(companyReview.getPros());
		reviewUpdate.setCons(companyReview.getCons());
		reviewUpdate.setRecommendation(companyReview.isRecommendation());
		reviewUpdate.setAdvice(companyReview.getAdvice());

		return reviewUpdate;
	}

	public boolean deleteReview(Integer reviewId) {
		boolean isDeleted = false;
		System.out.println("Inside delete review");
		CompanyReview cr = em.find(CompanyReview.class, reviewId);

		if (cr != null) {
			em.remove(cr);
			em.flush();
			if (!em.contains(cr)) {
				isDeleted = true;
			}
		}
		return isDeleted;

	}

	@Override
	public CompanyReview createUserReview(CompanyReview companyReview) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompanyReview findReviewById(Integer reviewId) {
		return em.find(CompanyReview.class, reviewId);

	}

}
