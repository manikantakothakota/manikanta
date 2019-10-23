package com.survey.master.SurveyMasterAPI.Model;

public class QuestionAnswersCountResponse {

	private String name;
	private Long count;

	public QuestionAnswersCountResponse(String answer, Long cnt) {
		this.name = answer;
		this.count = cnt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

}
