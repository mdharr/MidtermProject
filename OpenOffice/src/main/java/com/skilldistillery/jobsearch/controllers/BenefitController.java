package com.skilldistillery.jobsearch.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.skilldistillery.jobsearch.data.BenefitDAO;

@Controller
public class BenefitController {
	
	@Autowired
	private BenefitDAO dao;
}
