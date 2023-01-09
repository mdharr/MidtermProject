package com.skilldistillery.jobsearch.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jobsearch.entities.Article;
import com.skilldistillery.jobsearch.entities.User;

@Service
@Transactional
public class ArticleDAOImpl implements ArticleDAO {
 
	@PersistenceContext
	private EntityManager em;

	@Override
	public Article findArticleById(Integer articleId) {
		Article article = em.find(Article.class, articleId);
		return article;
	}
	
	@Override
	public List<Article> findAllArticles() {
		String jpql = "SELECT article FROM Article article";
		return em.createQuery(jpql, Article.class).getResultList();
	}



	@Override
	public List<Article> findArticle(String title) {
		List<Article> ans = new ArrayList<>();
		String jpql = "select article from Article article where article.title like :title";

		ans = em.createQuery(jpql, Article.class).setParameter("title", "%" + title + "%").getResultList();
		return ans;
	}
	
	
}
