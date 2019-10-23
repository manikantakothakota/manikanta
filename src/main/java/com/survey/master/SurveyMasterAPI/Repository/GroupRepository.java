package com.survey.master.SurveyMasterAPI.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.survey.master.SurveyMasterAPI.Entity.Group;


/**
 * This repository will communicate with Group table of database using JPA
 * @author DKOTTAKOTA
 *
 */

@Repository
public interface GroupRepository extends CrudRepository<Group, Long>{

}
