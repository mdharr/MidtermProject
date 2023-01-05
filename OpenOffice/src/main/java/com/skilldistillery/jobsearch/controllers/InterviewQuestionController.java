package com.skilldistillery.jobsearch.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.jobsearch.data.InterviewQuestionDAO;
import com.skilldistillery.jobsearch.entities.InterviewQuestion;

@Controller
public class InterviewQuestionController {

	@Autowired
	private InterviewQuestionDAO dao;
	
	@RequestMapping("createInterviewQuestion")
	public String createInterviewQuestion() {
		return "createInterviewQuestion";
	}
	
	@RequestMapping("updatingInterviewQuestion")
	public String updatineInterviewQuestion(InterviewQuestion question, Integer interviewId, Model model ) {
		dao.addInterviewQuestion(question, interviewId);
		model.addAttribute("interview", dao.findInterviewById(interviewId) );
		return "interviewBio";
	}

	@RequestMapping("addAnotherInterviewQuestion")
	public String addAnotherInterviewQuestion(InterviewQuestion question, Integer interviewId ) {
		question = dao.addInterviewQuestion(question, interviewId);
		return "createInterviewQuestion";
	}
	
}
