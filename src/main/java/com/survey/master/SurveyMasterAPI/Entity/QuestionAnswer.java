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

/**
 * This entity will create a question_answer table. This is responsible for
 * storing of answers against question_options and question
 * 
 * @author DKOTTAKOTA
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "question_answer")
public class QuestionAnswer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	/*
	 * @Column(name = "question_option_id") private Long questionOptionId;
	 */

	/**
	 * It will create foriegn key constraint for primary key of question_options
	 */
	// @JsonIgnoreProperties("questionOptions")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "question_option_id")
	private QuestionOptions questionOption;

	// @JsonIgnoreProperties("questionOptions")
	// @ManyToOne(fetch = FetchType.EAGER)
	// @ManyToOne()
	// @JoinColumn(name = "question_id")
	private Long question_id;

	@Column(name = "other_answer")
	private String otherAnswer;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public QuestionOptions getQuestionOption() {
		return questionOption;
	}

	public void setQuestionOption(QuestionOptions questionOption) {
		this.questionOption = questionOption;
	}

	public Long getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(Long question_id) {
		this.question_id = question_id;
	}

	public String getOtherAnswer() {
		return otherAnswer;
	}

	public void setOtherAnswer(String otherAnswer) {
		this.otherAnswer = otherAnswer;
	}

}
