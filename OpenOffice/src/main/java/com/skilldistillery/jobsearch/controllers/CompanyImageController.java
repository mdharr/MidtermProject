package com.skilldistillery.jobsearch.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.skilldistillery.jobsearch.data.CompanyImageDAO;

@Controller
public class CompanyImageController {
	@Autowired
	private CompanyImageDAO dao;
	
	
}
