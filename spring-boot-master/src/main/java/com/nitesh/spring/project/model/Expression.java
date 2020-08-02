package com.nitesh.spring.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Expression")
public class Expression {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "expressionId")
	private int expressionId;

	@Column(name = "expressionQuestion")
	private String expressionQuestion;

	@Column(name = "expressionAnswer")
	private String expressionAnswer;
	
	@Column(name = "expressionContent")
	private String expressionContent;

	public int getExpressionId() {
		return expressionId;
	}

	public void setExpressionId(int expressionId) {
		this.expressionId = expressionId;
	}

	public String getExpressionQuestion() {
		return expressionQuestion;
	}

	public void setExpressionQuestion(String expressionQuestion) {
		this.expressionQuestion = expressionQuestion;
	}

	public String getExpressionAnswer() {
		return expressionAnswer;
	}

	public void setExpressionAnswer(String expressionAnswer) {
		this.expressionAnswer = expressionAnswer;
	}

	public String getExpressionContent() {
		return expressionContent;
	}

	public void setExpressionContent(String expressionContent) {
		this.expressionContent = expressionContent;
	}


}