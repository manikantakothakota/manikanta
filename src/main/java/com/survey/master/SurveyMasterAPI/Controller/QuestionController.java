package com.survey.master.SurveyMasterAPI.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.survey.master.SurveyMasterAPI.Entity.Question;
import com.survey.master.SurveyMasterAPI.Entity.QuestionType;
import com.survey.master.SurveyMasterAPI.Repository.QuestionTypeRepository;
import com.survey.master.SurveyMasterAPI.Service.QuestionService;

/**
 * This controller will be available to UI for accessing question data
 * 
 * @author DKOTTAKOTA
 *
 */

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class QuestionController {

	@Autowired
	QuestionService questionService;

	@Autowired
	QuestionTypeRepository questionTypeRepository;

	@GetMapping("/questions")
	public Iterable<Question> getAllQuestions() {
		Iterable<Question> questions = questionService.getAllQuestions();
		return questions;
	}

	@PostMapping("/question")
	public Question saveQuestion(@Valid @RequestBody Question question) {
		return questionService.saveQuestion(question);
	}

	// Update a Note
	@PutMapping("question")
	public Question updateQuestion(@Valid @RequestBody Question questionDetails) {
		return questionService.updateQuestion(questionDetails);
	}

	@DeleteMapping("/question/{id}")
	public void deleteQuestion(@PathVariable(value = "id") Long id) {
		questionService.deleteQuestion(id);
	}

	@GetMapping("/questionTypes")
	public Iterable<QuestionType> getAllQuestionTypes() {
		return questionTypeRepository.findAll();
	}
}
