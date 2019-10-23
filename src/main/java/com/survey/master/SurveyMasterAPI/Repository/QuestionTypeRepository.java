package com.survey.master.SurveyMasterAPI.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.survey.master.SurveyMasterAPI.Entity.QuestionType;

/**
 * This repository will communicate with Question table of database using JPA
 * @author DKOTTAKOTA
 *
 */

@Repository
public interface QuestionTypeRepository extends CrudRepository<QuestionType, Long> {

}
