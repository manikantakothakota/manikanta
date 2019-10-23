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

import com.survey.master.SurveyMasterAPI.Entity.QuestionOptions;
import com.survey.master.SurveyMasterAPI.Service.QuestionOptionsService;

/**
 * This controller will be available to UI for accessing question options data
 * @author DKOTTAKOTA
 *
 */

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class QuestionOptionsController {

	@Autowired
	QuestionOptionsService questionOptionsService;

	@GetMapping("/questionOptions")
	public Iterable<QuestionOptions> getAllQuestionOptions() {
		return questionOptionsService.getAllQuestionOptions();
	}

	@PostMapping("/questionOption")
	public QuestionOptions saveQuestionOption(@Valid @RequestBody QuestionOptions questionOptions) {
		return questionOptionsService.saveQuestionOption(questionOptions);
	}

	// Update a Note
	@PutMapping("questionOption")
	public QuestionOptions updateQuestionOption(@Valid @RequestBody QuestionOptions questionDetails) {
		return questionOptionsService.updateQuestionOption(questionDetails);
	}

	@DeleteMapping("/questionOption/{id}")
	public void deleteQuestionOption(@PathVariable(value = "id") Long id) {
		questionOptionsService.deleteQuestionOption(id);
	}
}
