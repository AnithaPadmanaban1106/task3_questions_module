package com.revature.revaturequestion.model;

import lombok.Data;

@Data
public class Question {

	

	private String questionId;

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
	
	private String categoryName;
	private String levelName;

	}
