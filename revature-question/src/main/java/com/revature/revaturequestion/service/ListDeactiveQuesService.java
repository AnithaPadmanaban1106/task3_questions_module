package com.revature.revaturequestion.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.revaturequestion.dao.ListDeactiveQuestionDAOImpl;
import com.revature.revaturequestion.exception.ServiceException;
import com.revature.revaturequestion.model.Question;

@Service
public class ListDeactiveQuesService {
	@Autowired
	ListDeactiveQuestionDAOImpl listDeactiveQuestionDAOImpl;
	
	@Transactional
	public List<Question> listDeactiveques() throws ServiceException, SQLException
	{
		List<Question> question=null;
		try {
			
			question=listDeactiveQuestionDAOImpl.listDeactiveQuestions();
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException("Unable to show");
		}
		System.out.println("list"+question);
		return question;
	}
	
}
