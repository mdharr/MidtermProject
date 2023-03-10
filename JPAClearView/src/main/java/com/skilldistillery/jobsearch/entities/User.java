package com.skilldistillery.jobsearch.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String username;

	private String password;

	private Boolean enabled;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	private Boolean role;

	private String email;

	@Column(name = "img_url")
	private String imgUrl;

	private String description;

	@OneToMany(mappedBy = "user")
	private List<Article> articles;

	@OneToMany(mappedBy = "user")
	private List<CompanyReview> reviews;

	@OneToMany(mappedBy = "user")
	private List<Interview> interviews;
	
	@ManyToMany
	@JoinTable(name="user_subscribed_to_company",		
	joinColumns=@JoinColumn(name="user_id"),
	inverseJoinColumns=@JoinColumn(name="company_id"))
	private List<Company> companies;

	public User() {
	}
	

	public List<Interview> getInterviews() {
		return interviews;
	}


	public void setInterviews(List<Interview> interviews) {
		this.interviews = interviews;
	}
	
	public void addInterview(Interview interview) {
		if (interviews == null) {
			interviews = new ArrayList<>();
		}
		if (!interviews.contains(interview)) {
			interviews.add(interview);
			interview.getUser().removeInterview(interview);
		}
		interview.setUser(this);
	}

	public void removeInterview(Interview interview) {
		if (interviews != null && interviews.contains(interview)) {
			interviews.remove(interview);
			interview.setUser(null);
			
		}
	}
	public List<CompanyReview> getReviews() {
		return reviews;
	}

	public void setReviews(List<CompanyReview> reviews) {
		this.reviews = reviews;
	}

	public void addReview(CompanyReview review) {
		if (reviews == null) {
			reviews = new ArrayList<>();
		}
		if (!reviews.contains(review)) {
			reviews.add(review);
			review.getCompany().removeReview(review);
		}
		review.setUser(this);
	}

	public void removeReview(CompanyReview review) {
		if (reviews != null && reviews.contains(review)) {
			reviews.remove(review);
			review.setUser(null);
		}
	}
	
	public List<Company> getCompanies() {
		return companies;
	}
	
	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}
	
	public void addCompany(Company company) {
		if(companies == null) {
			companies = new ArrayList<>();
		}
		if (! companies.contains(company)) {
			companies.add(company);
			company.addUser(this);
		}
	}
	
	public void removeCompany(Company company) {
		if (companies != null && companies.contains(company)) {
			companies.remove(company);
			company.removeUser(this);
		}
	}
	
	
	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public void addArticle(Article article) {
		if (articles == null) {
			articles = new ArrayList<>();
		}
		if (!articles.contains(article)) {
			articles.add(article);
			article.getIndustry().removeArticle(article);
		}
		article.setUser(this);
	}

	public void removeArticle(Article article) {
		if (articles != null && articles.contains(article)) {
			articles.remove(article);
			article.setUser(null);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public boolean isRole() {
		return role;
	}


	public void setRole(boolean role) {
		this.role = role;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=").append(id).append(", username=").append(username).append(", password=")
				.append(password).append(", enabled=").append(enabled).append(", firstName=").append(firstName)
				.append(", lastName=").append(lastName).append(", role=").append(role).append(", email=").append(email)
				.append(", imgUrl=").append(imgUrl).append("]");
		return builder.toString();
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return id == other.id;
	}

}
