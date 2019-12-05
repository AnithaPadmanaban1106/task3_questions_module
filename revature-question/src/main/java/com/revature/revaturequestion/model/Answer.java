package com.revature.revaturequestion.model;

import lombok.Data;

@Data

public class Answer {

	
	private Integer id;
	private Integer questionId;
	private String option;
	private Boolean isRightAnswer;
	private String rightAnswerExplanation;
	private String grading;
	private Boolean isStricky;
}
