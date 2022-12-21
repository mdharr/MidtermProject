package com.skilldistillery.jobsearch.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.jobsearch.data.UserDAO;

@Controller
public class UserController {
	
	@Autowired
	private UserDAO userDao;
	@RequestMapping(path = {"/", "home.do"})
	public String home(Model model) {
		model.addAttribute("SMOKETEST", userDao.findById(1));
		return "home";
	}

}
