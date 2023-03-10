package com.skilldistillery.jobsearch.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Benefit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String description;
	
	private String name;
	
	private Boolean perk;
	
	@ManyToMany(mappedBy="benefits")
	private List<Company> companies;
	
	public Benefit() {}
	
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
			company.addBenefit(this);
		}
	}
	
	public void removeCompany(Company company) {
		if (companies != null && companies.contains(company)) {
			companies.remove(company);
			company.removeBenefit(this);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getPerk() {
		return perk;
	}

	public void setPerk(Boolean perk) {
		this.perk = perk;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Benefit [id=").append(id).append(", description=").append(description).append(", name=")
				.append(name).append(", perk=").append(perk).append("]");
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
		Benefit other = (Benefit) obj;
		return id == other.id;
	}
	
	

}
