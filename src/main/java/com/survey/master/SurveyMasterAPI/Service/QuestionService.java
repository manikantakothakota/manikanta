package com.survey.master.SurveyMasterAPI.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.master.SurveyMasterAPI.ResourceNotFoundException;
import com.survey.master.SurveyMasterAPI.Entity.Question;
import com.survey.master.SurveyMasterAPI.Repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	QuestionRepository questionRepository;

	public Iterable<Question> getAllQuestions() {
		return questionRepository.findAll();
	}

	public Question saveQuestion(Question question) {
		return questionRepository.save(question);
	}

	public Question updateQuestion(Question questionDetails) {
		Question question = questionRepository.findById(questionDetails.getId())
				.orElseThrow(() -> new ResourceNotFoundException("question", "id", questionDetails.getId()));
		question.setQuestionText(questionDetails.getQuestionText());

		Question updatedQuestion = questionRepository.save(question);
		return updatedQuestion;
	}

	public void deleteQuestion(Long id) {
		Question question = questionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("question", "id", id));

		questionRepository.deleteQuestionAnswers(id);
		questionRepository.deleteQuestionOptions(id);
		questionRepository.delete(question);
	}

}
