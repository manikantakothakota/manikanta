package com.survey.master.SurveyMasterAPI.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This entity will create a question_options table. This is responsible for
 * relating questions to its options.
 * 
 * @author DKOTTAKOTA
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "question_options")
public class QuestionOptions implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	/**
	 * It will create foriegn key constraint for primary key of question
	 */
	@JsonIgnoreProperties("questionOptions")
	@ManyToOne(fetch = FetchType.EAGER)
	// @ManyToOne()
	@JoinColumn(name = "question_id")
	private Question question;

	@Column(name = "options_text")
	private String optionText;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getOptionText() {
		return optionText;
	}

	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}

}
