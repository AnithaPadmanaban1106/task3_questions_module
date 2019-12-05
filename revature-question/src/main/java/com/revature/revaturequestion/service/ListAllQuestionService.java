package com.revature.revaturequestion.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.revaturequestion.dao.ListAllQuestionDAOImpl;
import com.revature.revaturequestion.exception.ServiceException;
import com.revature.revaturequestion.model.Question;

@Service
public class ListAllQuestionService {
	@Autowired
	ListAllQuestionDAOImpl listAllQuestionDAOImpl;
	
	@Transactional
	public List<Question> listAll() throws ServiceException, SQLException
	{
		List<Question> question=null;
		try {
			
			question=listAllQuestionDAOImpl.listAllQuestions();
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException("Unable to show");
		}
		System.out.println("list"+question);
		return question;
	}
	
}

