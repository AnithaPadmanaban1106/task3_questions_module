package com.revature.revaturequestion.dao;

import java.sql.SQLException;

import com.revature.revaturequestion.model.Answer;
import com.revature.revaturequestion.model.Question;

public interface IAnswerQuestionDAO {
	public boolean saveQuestionAnswer(Question question,Answer answer) throws SQLException;

}
