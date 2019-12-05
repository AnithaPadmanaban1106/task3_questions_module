package com.revature.revaturequestion.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.revaturequestion.model.Question;

public interface IListAllQuestionDAO {
	public List<Question> listAllQuestions() throws SQLException;
}
