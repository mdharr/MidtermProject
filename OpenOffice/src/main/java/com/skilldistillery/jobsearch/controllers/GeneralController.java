package com.skilldistillery.jobsearch.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.jobsearch.entities.User;

@Controller
public class GeneralController {

	@RequestMapping(path = { "/", "home" })
	public String home(Model model) {

		return "home";
	}

	@RequestMapping("search")
	public String sendToSearchPage() {
		return "search";
	}

	@RequestMapping("login")
	public String sendToLoginPage() {
		return "login";
	}

	@RequestMapping(path = "loggingOut.do")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:home";
	}

	@RequestMapping("register")
	public String sendToRegisterPage() {
		return "register";
	}

	public static User refreshUser(User user, HttpSession session) {
			session.removeAttribute("user");
			user.getReviews().size();
			user.getArticles().size();
			session.setAttribute("user", user);
			return user;
	}

}
