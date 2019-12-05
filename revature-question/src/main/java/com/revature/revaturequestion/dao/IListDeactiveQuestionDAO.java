package com.revature.revaturequestion.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.revaturequestion.model.Question;

public interface IListDeactiveQuestionDAO {
	
	public List<Question> listDeactiveQuestions() throws SQLException;
}
