package com.revature.revaturequestion.dao;

import com.revature.revaturequestion.dto.QuestionDTO;
import com.revature.revaturequestion.exception.DBException;
import com.revature.revaturequestion.model.Answer;
import com.revature.revaturequestion.model.Question;

public interface QuestionDAO {
	
	public boolean saveQuestionAnswer(Question question,QuestionDTO questionDTO) throws DBException;
	
	public boolean deleteQuestion(String questionId) throws DBException;

	public boolean updateQuestion(String questionId, String status) throws DBException;
	
	public boolean update(Question question, Answer answer) throws DBException;

}
