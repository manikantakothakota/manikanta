package com.survey.master.SurveyMasterAPI.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.master.SurveyMasterAPI.ResourceNotFoundException;
import com.survey.master.SurveyMasterAPI.Entity.QuestionOptions;
import com.survey.master.SurveyMasterAPI.Repository.QuestionAnswerRepository;
import com.survey.master.SurveyMasterAPI.Repository.QuestionOptionsRepository;

@Service
public class QuestionOptionsService {

	@Autowired
	QuestionOptionsRepository questionOptionsRepository;
	
	@Autowired
	QuestionAnswerRepository questionAnswerRepository;

	public Iterable<QuestionOptions> getAllQuestionOptions() {
		return questionOptionsRepository.findAll();
	}

	public QuestionOptions saveQuestionOption(QuestionOptions questionOptions) {
		return questionOptionsRepository.save(questionOptions);
	}

	public QuestionOptions updateQuestionOption(QuestionOptions questionOptionDetails) {
		QuestionOptions questionOptions = questionOptionsRepository.findById(questionOptionDetails.getId())
				.orElseThrow(() -> new ResourceNotFoundException("question", "id", questionOptionDetails.getId()));
		questionOptions.setOptionText(questionOptionDetails.getOptionText());

		QuestionOptions updatedQuestionOptions = questionOptionsRepository.save(questionOptions);
		return updatedQuestionOptions;
	}

	public void deleteQuestionOption(Long id) {
		QuestionOptions questionOptions = questionOptionsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("question", "id", id));

		questionAnswerRepository.deleteByQuestionOptionId(id);
		questionOptionsRepository.delete(questionOptions);
		// return questionRepository.delete(questionRepository.findById(id));
	}

}
