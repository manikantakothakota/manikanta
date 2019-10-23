package com.survey.master.SurveyMasterAPI.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.survey.master.SurveyMasterAPI.Entity.Question;

/**
 * This repository will communicate with Question table of database using JPA
 * @author DKOTTAKOTA
 *
 */

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {

	@Modifying
	@Transactional
	@Query(value = "DELETE \r\n" + "FROM question_answer AS qa \r\n" + "USING question_options AS qo, question AS q\r\n"
			+ "WHERE (qa.question_option_id = qo.id) AND  (q.id = qo.question_id) AND q.id = :questionId", nativeQuery = true)
	public void deleteQuestionAnswers(@Param("questionId") Long questionId);

	@Modifying
	@Transactional
	@Query(value = "DELETE \r\n" + "FROM question_options qo\r\n" + "USING question q\r\n"
			+ "WHERE qo.question_id = q.id\r\n" + "  and q.id = :questionId", nativeQuery = true)
	public void deleteQuestionOptions(@Param("questionId") Long questionId);
}
