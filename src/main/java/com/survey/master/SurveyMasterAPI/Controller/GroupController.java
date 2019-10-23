package com.survey.master.SurveyMasterAPI.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.survey.master.SurveyMasterAPI.Entity.Group;
import com.survey.master.SurveyMasterAPI.Service.GroupService;

/**
 * This controller will be available to UI for accessing groups related data
 * @author DKOTTAKOTA
 *
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class GroupController {

	@Autowired
	GroupService groupService;

	@GetMapping("/groups")
	public Iterable<Group> getAllGroups() {
		Iterable<Group> questions = groupService.getAllGroups();
		return questions;
	}
	
	@GetMapping("/group/{id}")
	public Group getGroupQuestions(@PathVariable(value = "id") Long id) {
		return groupService.getGroupQuestions(id);
	}

	@PostMapping("/group")
	public Iterable<Group> saveGroup(@Valid @RequestBody Group group) {
		Group group1 = groupService.saveGroup(group);
		return getAllGroups();
	}
}
