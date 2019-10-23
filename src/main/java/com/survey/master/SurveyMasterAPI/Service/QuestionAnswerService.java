package com.survey.master.SurveyMasterAPI.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.master.SurveyMasterAPI.Entity.QuestionAnswer;
import com.survey.master.SurveyMasterAPI.Model.QuestionAnswersCountResponse;
import com.survey.master.SurveyMasterAPI.Repository.QuestionAnswerRepository;

@Service
public class QuestionAnswerService {

	@Autowired
	QuestionAnswerRepository questionAnswerRepository;

	public void getAllAnswers() {

	}

	public void getAllAnswersOfQuestion(Long id) {

	}

	public QuestionAnswer createQuestionAnswer(QuestionAnswer questionAnswer) {
		return questionAnswerRepository.save(questionAnswer);
	}

	public Iterable<QuestionAnswer> saveAllQuestionAnswers(List<QuestionAnswer> questionAnswers) {
		return questionAnswerRepository.saveAll(questionAnswers);
	}
	
	/*public List<QuestionAnswersCountResponse> groupAnswersByQuestion(Integer questionId) {
		return questionAnswerRepository.groupAnswersByQuestion(questionId);
	}*/

	public List<QuestionAnswersCountResponse> groupAnswersByQuestion(Long questionId) {
		return questionAnswerRepository.groupAnswersByQuestion(questionId);
	}
	
	public List<QuestionAnswer> getAnswerData(Long questionId) {
		return questionAnswerRepository.getAnswerData(questionId);
	}
}
