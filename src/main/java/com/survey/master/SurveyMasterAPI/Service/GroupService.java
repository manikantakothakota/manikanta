package com.survey.master.SurveyMasterAPI.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.master.SurveyMasterAPI.ResourceNotFoundException;
import com.survey.master.SurveyMasterAPI.Entity.Group;
import com.survey.master.SurveyMasterAPI.Repository.GroupRepository;

@Service
public class GroupService {

	@Autowired
	GroupRepository groupRepository;

	public Iterable<Group> getAllGroups() {
		return groupRepository.findAll();
	}
	
	public Group getGroupQuestions(Long id) {
		return groupRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("group", "id", id));
	}

	public Group saveGroup(Group group) {
		return groupRepository.save(group);
	}
}
