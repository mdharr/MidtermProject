package com.skilldistillery.jobsearch.data;

import java.util.List;

import com.skilldistillery.jobsearch.entities.Company;

public interface CompanyDAO {

	public List<Company> findCompanies(String name);

	List<Company> findAllCompanies();

	Company findCompanyById(Integer companyId);
	
	Company updateCompany(Integer companyId, Company company);
	
	Company createCompany(Company company);
}
