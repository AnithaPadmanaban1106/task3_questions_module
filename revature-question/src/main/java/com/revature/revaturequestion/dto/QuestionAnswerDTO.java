package com.revature.revaturequestion.dto;

import com.revature.revaturequestion.model.QuestionType;

import lombok.Data;

@Data
public class QuestionAnswerDTO {
	private Integer questionId;
	
	private String option;
	
	private Boolean isRightAnswer;
	
	private String rightAnswerExplanation;
	
	private String grading;
	
	private Boolean isStricky;
	
	private String title;

	private QuestionType questionType;

	private String content;

	private Integer categoryId;

	private String tag;

	private Integer levelId;

	private Integer skillPoints;

	private Double score;

	private String duration;

	private Boolean status;

	private Boolean isImported;
}
