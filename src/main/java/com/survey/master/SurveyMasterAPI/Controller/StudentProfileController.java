package com.survey.master.SurveyMasterAPI.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.survey.master.SurveyMasterAPI.Entity.StudentProfile;
import com.survey.master.SurveyMasterAPI.Service.StudentProfileService;

//@Controller
@RestController
@RequestMapping("/api")
public class StudentProfileController {

	@Autowired
	StudentProfileService studentprofileservice;
	
	@PostMapping("/student")
	public StudentProfile saveStudent(@Valid @RequestBody StudentProfile student) {
		return studentprofileservice.saveStudent(student);	
	}
	
	@DeleteMapping("/student/{id}")
	public void deleteStudent(@PathVariable(value = "id") long id ) {
		studentprofileservice.deleteStudent(id);
	}
	
	@PutMapping("/student/{id}")
	public StudentProfile updateStudent(@Valid @RequestBody StudentProfile student,@PathVariable(value = "id") Long Id) {
		return studentprofileservice.updateStudent(student,Id);
	}
	
	@GetMapping("/student/{id}")
	public StudentProfile findStudent(@PathVariable(value = "id") Long id) {
		return studentprofileservice.getStudentById(id);
	}
	@GetMapping("/students")
	public Iterable<StudentProfile> loadAll(){
		return studentprofileservice.loadAll();
		
	}
}
