package com.survey.master.SurveyMasterAPI.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * This entity will create a question_group table. This is responsible for
 * relating questions to group.
 * 
 * @author DKOTTAKOTA
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "question_group")
public class Group {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	private String name;

	/**
	 * This will create relationship between question_group and question tables. The
	 * id of here is foriegn key of question table(group_id) If you access group, it
	 * will pull group information along with its chained questions.
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
	private List<Question> questions;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

}
