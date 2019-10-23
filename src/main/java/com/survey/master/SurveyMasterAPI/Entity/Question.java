package com.survey.master.SurveyMasterAPI.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This entity will create a question table. This is responsible for relating
 * questions to group.
 * 
 * @author DKOTTAKOTA
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "question")
public class Question implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "question_text")
	private String questionText;

	/**
	 * It will create foriegn key constraint for primary key of question_group
	 * table. Fetch type LAZY will load this group entity from database whenever
	 * needed only. If we use EAGER irrespective of usage it will fetch data from
	 * database
	 */
	@JsonIgnoreProperties("questions")
	@ManyToOne(fetch = FetchType.EAGER)
	// @ManyToOne()
	@JoinColumn(name = "group_id")
	private Group group;
	
	@JsonIgnoreProperties("questions")
	@ManyToOne(fetch = FetchType.EAGER)
	// @ManyToOne()
	@JoinColumn(name = "type_id")
	private QuestionType questionType;

	/**
	 * This will create relationship between question_options and question tables.
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
	private List<QuestionOptions> questionOptions;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public List<QuestionOptions> getQuestionOptions() {
		return questionOptions;
	}

	public void setQuestionOptions(List<QuestionOptions> questionOptions) {
		this.questionOptions = questionOptions;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}
	
	

}
