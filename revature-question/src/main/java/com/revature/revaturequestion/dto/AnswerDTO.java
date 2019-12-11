package com.revature.revaturequestion.dto;

import com.revature.revaturequestion.model.QuestionType;

import lombok.Data;


@Data
public class AnswerDTO {
	private String id;
	private String questionId;
	private String option;
	private Boolean isRightAnswer;
	private String rightAnswerExplanation;
	private String grading;
	private Boolean isStricky;
	
	private String title;

	private QuestionType questionType;

	private String content;

	private String categoryId;

	private String tag;

	private String levelId;

	private String skillPoints;

	private String score;

	private String duration;

	private Boolean status;

	private Boolean isImported;

	}
