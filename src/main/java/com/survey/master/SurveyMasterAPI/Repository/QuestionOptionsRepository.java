package com.survey.master.SurveyMasterAPI.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.survey.master.SurveyMasterAPI.Entity.QuestionOptions;

/**
 * This repository will communicate with QuestionOptions table of database using JPA
 * @author DKOTTAKOTA
 *
 */

@Repository
public interface QuestionOptionsRepository extends CrudRepository<QuestionOptions, Long> {

}
