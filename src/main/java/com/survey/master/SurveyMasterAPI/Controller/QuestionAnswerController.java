package com.survey.master.SurveyMasterAPI.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.survey.master.SurveyMasterAPI.Entity.QuestionAnswer;
import com.survey.master.SurveyMasterAPI.Model.QuestionAnswersCountResponse;
import com.survey.master.SurveyMasterAPI.Service.QuestionAnswerService;

/**
 * This controller will be available to UI for accessing question answers related data and chart data
 * @author DKOTTAKOTA
 *
 */

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class QuestionAnswerController {

	@Autowired
	QuestionAnswerService questionAnswerService;

	@PostMapping("/questionAnswer")
	public QuestionAnswer saveQuestion(@Valid @RequestBody QuestionAnswer questionAnswer) {
		return questionAnswerService.createQuestionAnswer(questionAnswer);
	}

	@PostMapping("/allQuestionAnswers")
	public Iterable<QuestionAnswer> saveAllQuestionAnswers(@Valid @RequestBody List<QuestionAnswer> questionAnswers) {
		return questionAnswerService.saveAllQuestionAnswers(questionAnswers);
	}

	@GetMapping("/groupAnswersByQuestion/{questionId}")
	public List<QuestionAnswersCountResponse> groupAnswersByQuestion(
			@PathVariable(value = "questionId") Long questionId) {
		return questionAnswerService.groupAnswersByQuestion(questionId);
	}
	
	@GetMapping("/getAnswerData/{questionId}")
	public List<QuestionAnswer> getAnswerData(
			@PathVariable(value = "questionId") Long questionId) {
		return questionAnswerService.getAnswerData(questionId);
	}
}
