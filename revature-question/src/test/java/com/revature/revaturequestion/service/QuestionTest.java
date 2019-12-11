package com.revature.revaturequestion.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.revature.revaturequestion.dao.QuestionDAOImpl;
import com.revature.revaturequestion.exception.ServiceException;
import com.revature.revaturequestion.exception.ValidatorException;
import com.revature.revaturequestion.model.Question;
import com.revature.revaturequestion.validator.QuestionValidator;

//@RunWith(SpringRunner.class)
public class QuestionTest {
	QuestionService questionService = new QuestionService(new QuestionDAOImpl(), new QuestionValidator());

	// DataSource dataSource;

	// ListAllQuestionService listAllQuestionService = new
	// ListAllQuestionService(new ListAllQuestionDAOImpl(dataSource));

	// ListAllQuestionDAOImpl obj=new ListAllQuestionDAOImpl();

	/*
	 * @Test void validDeleteQuestionTest() throws ValidatorException,
	 * ServiceException {
	 * 
	 * String questionId = "35"; Boolean result = false; result =
	 * questionService.deleteQuestion(questionId); assertTrue(result); }
	 */

	@Test
	public void inValidDeleteQuestionTest() throws ValidatorException, ServiceException {
		String questionId = "3";
		Boolean result = false;
		result = questionService.deleteQuestion(questionId);
		assertFalse(result);

	}

	@Test
	public void validListAllActiveQuestionTest() throws ServiceException  {
		String status = "1";
		List<Question> question = null;
		question = questionService.listAll(status);
		assertNotNull(question);
	}

	@Test
	public void updateQuestionDeactiveValidTest() throws ServiceException{

		String status = "0";
		String questionId = "22";
		Boolean question = false;
		question = questionService.updateQuestion(questionId, status);
		assertTrue(question);

	}

	@Test
	public void updateQuestionActiveValidTest() throws ServiceException {

		String status = "1";
		String questionId = "22";
		Boolean question = false;
		question = questionService.updateQuestion(questionId, status);
		assertTrue(question);

	}

	@Test(expected = ServiceException.class)
	public void updateQuestionActiveInValidTest() throws ServiceException {
		String status = "=";
		String questionId = "22";

		questionService.updateQuestion(questionId, status);

	}

	@Test(expected = ServiceException.class)
	public void updateQuestionDeactiveInValidTest() throws ServiceException {
		String status = "df";
		String questionId = "22";
		questionService.updateQuestion(questionId, status);
	}
}
