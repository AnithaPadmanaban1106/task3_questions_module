package com.revature.revaturequestion.model;



import lombok.Data;

@Data

public class QuestionMatching {
	private String id;
	private String questionId;
	private String answerId;
	private String question;
	private String isSticky;
}
