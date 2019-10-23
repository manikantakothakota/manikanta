package com.survey.master.SurveyMasterAPI;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.survey.master.SurveyMasterAPI.Controller.StudentProfileController;
import com.survey.master.SurveyMasterAPI.Entity.StudentProfile;
import com.survey.master.SurveyMasterAPI.Repository.StudentProfileRepository;
import com.survey.master.SurveyMasterAPI.Service.StudentProfileService;

@RunWith(SpringRunner.class)
public class StudentProfileControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	StudentProfileController controller;
	@Mock 
	StudentProfileService studentprofileservice;
	@Mock
	StudentProfileRepository Repository;
	
	@Before
	public void setUp(){
		mockMvc = MockMvcBuilders.standaloneSetup(controller)
				.build();
	}
	
	public void init() {
	}
	protected String mapToJson(Object obj) throws JsonProcessingException {
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.writeValueAsString(obj);
	}

	@Test
	public void saveStudenttest() throws Exception {

		StudentProfile sp=new StudentProfile(); 
		sp.setName("mani");
		sp.setEmail("man@gmail.com");
		sp.setPhone("9490927426");
		when(studentprofileservice.saveStudent(sp)).thenReturn(sp);
		when(controller.saveStudent(sp));
		
	}

	@Test
	public void deletestudenttest()throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/student/123")
				.accept(MediaType.APPLICATION_JSON));
	}
	@Test
	public void updatestudenttest()throws Exception {
		 String uri = "/student/2";
		StudentProfile sp=new StudentProfile();
		sp.setName("mani");
		sp.setEmail("man@gmail.com");
		sp.setPhone("9490927426");  
		String inputJson = this.mapToJson(sp);
	      mockMvc.perform(MockMvcRequestBuilders.put(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	
	}

}
