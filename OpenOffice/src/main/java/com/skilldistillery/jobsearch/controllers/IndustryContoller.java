package com.skilldistillery.jobsearch.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.skilldistillery.jobsearch.data.IndustryDAO;

@Controller
public class IndustryContoller {

	@Autowired
	private IndustryDAO dao;
}
