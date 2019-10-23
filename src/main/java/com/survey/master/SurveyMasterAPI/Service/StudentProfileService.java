package com.survey.master.SurveyMasterAPI.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.master.SurveyMasterAPI.ResourceNotFoundException;
import com.survey.master.SurveyMasterAPI.Entity.StudentProfile;
import com.survey.master.SurveyMasterAPI.Repository.StudentProfileRepository;

@Service
public class StudentProfileService {

	@Autowired
	StudentProfileRepository studentprofilerepository;

	public StudentProfile saveStudent(StudentProfile student) {
		return studentprofilerepository.save(student);
	}

	public void deleteStudent(Long id) {
		studentprofilerepository.deleteById((long) id);
	}
	public StudentProfile getStudentById(Long id) {
		StudentProfile student = studentprofilerepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("student", "id", id));
		return student;
	}
	public StudentProfile updateStudent(StudentProfile student,Long id) {
		StudentProfile student1 = studentprofilerepository.findById(id)
				.orElseThrow(() -> new 
						ResourceNotFoundException("student", "id", student.getId()));
		student1.setName(student.getName());
		student1.setEmail(student.getEmail());
		student1.setPhone(student.getPhone());

		StudentProfile updatedstudent=studentprofilerepository.save(student1);
		return updatedstudent;
	}

	public Iterable<StudentProfile> loadAll(){
		return studentprofilerepository.findAll();
		
	}
}
