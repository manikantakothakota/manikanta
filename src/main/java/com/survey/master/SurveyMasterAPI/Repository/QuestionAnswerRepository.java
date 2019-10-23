package com.survey.master.SurveyMasterAPI.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.survey.master.SurveyMasterAPI.Entity.QuestionAnswer;
import com.survey.master.SurveyMasterAPI.Model.QuestionAnswersCountResponse;

/**
 * This repository will communicate with QuestionAnswer table of database using JPA
 * @author DKOTTAKOTA
 *
 */

@Repository
public interface QuestionAnswerRepository extends CrudRepository<QuestionAnswer, Long> {

	@Query("select new com.survey.master.SurveyMasterAPI.Model.QuestionAnswersCountResponse(qo.optionText, count(qa.questionOption.id)) from QuestionAnswer qa\r\n"
			+ "join QuestionOptions qo on  qa.questionOption.id = qo.id\r\n"
			+ "join Question q on q.id = qo.question.id\r\n" + "where q.id = :questionId" + "\r\n"
			+ "group by qo.optionText, qa.questionOption.id")
	public List<QuestionAnswersCountResponse> groupAnswersByQuestion(@Param("questionId") Long questionId);
	
	@Transactional
    Long deleteByQuestionOptionId(Long id);
	
	@Query("select q from QuestionAnswer q where question_id = :questionId")
	public List<QuestionAnswer> getAnswerData(@Param("questionId") Long questionId);
}
