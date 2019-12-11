package com.revature.revaturequestion.dto;

import java.util.List;

import com.revature.revaturequestion.model.Answer;
import com.revature.revaturequestion.model.QuestionType;

public class QuestionDTO {


	

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
	
	private List<Answer> answer;

	

	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getLevelId() {
		return levelId;
	}

	public void setLevelId(String levelId) {
		this.levelId = levelId;
	}

	public String getSkillPoints() {
		return skillPoints;
	}

	public void setSkillPoints(String skillPoints) {
		this.skillPoints = skillPoints;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Boolean getIsImported() {
		return isImported;
	}

	public void setIsImported(Boolean isImported) {
		this.isImported = isImported;
	}

	
}
