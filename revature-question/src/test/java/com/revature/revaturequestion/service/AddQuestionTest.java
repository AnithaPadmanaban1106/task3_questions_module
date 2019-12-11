package com.revature.revaturequestion.service;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.revature.revaturequestion.dao.QuestionDAOImpl;
import com.revature.revaturequestion.dto.QuestionDTO;
import com.revature.revaturequestion.exception.ServiceException;
import com.revature.revaturequestion.exception.ValidatorException;
import com.revature.revaturequestion.model.Answer;
import com.revature.revaturequestion.model.QuestionType;
import com.revature.revaturequestion.validator.QuestionValidator;


public class AddQuestionTest {

	
	QuestionService questionService = new QuestionService(new QuestionDAOImpl(), new QuestionValidator());

	//@Test
	void addQuestionValidTest() throws ValidatorException, ServiceException, SQLException {

		Boolean result = false;

		String title = "Devops";

		QuestionType questionType = QuestionType.MultipleChoice;

		String content = "what is deveops";

		String categoryId = "3";

		String tag = "deveops";

		String levelId = "2";

		String skillPoints = "5";

		String score = "6";

		String duration = "11:23:21";

		Boolean status = true;

		Boolean isImported = true;

		String option = "development and integration";
		Boolean isRightAnswer = true;
		String rightAnswerExplanation = "right answer";
		String grading = "6";
		Boolean isStricky = true;

		Answer answer = new Answer();
		answer.setOption(option);
		answer.setIsRightAnswer(isRightAnswer);
		answer.setRightAnswerExplanation(rightAnswerExplanation);
		answer.setGrading(grading);
		answer.setIsStricky(isStricky);
		List<Answer> answerObj = new ArrayList<Answer>();
		answerObj.add(answer);
		QuestionDTO questionDTO = new QuestionDTO();
		questionDTO.setAnswer(answerObj);
		questionDTO.setTitle(title);
		questionDTO.setQuestionType(questionType);
		questionDTO.setContent(content);
		questionDTO.setCategoryId(categoryId);
		questionDTO.setTag(tag);
		questionDTO.setLevelId(levelId);
		questionDTO.setSkillPoints(skillPoints);
		questionDTO.setScore(score);
		questionDTO.setDuration(duration);
		questionDTO.setStatus(status);
		questionDTO.setIsImported(isImported);

		result = questionService.saveQuestionAnswer(questionDTO);
		assertTrue(result);

	}

	//@Test(expected = ServiceException.class)
	public void addquestionInvalidTest() throws ServiceException {

		String title = "#";

		QuestionType questionType = QuestionType.MultipleChoice;

		String content = "whatisdeveops";

		String categoryId = "3";

		String tag = "deveops";

		String levelId = "2";

		String skillPoints = "5";

		String score = "6";

		String duration = "11:23:21";

		Boolean status = true;

		Boolean isImported = true;

		String questionId = "23";
		String option = "developmentandintegration";
		Boolean isRightAnswer = true;
		String rightAnswerExplanation = "rightanswer";
		String grading = "6";
		Boolean isStricky = true;

		Answer answer = new Answer();
		answer.setQuestionId(questionId);
		answer.setOption(option);
		answer.setIsRightAnswer(isRightAnswer);
		answer.setRightAnswerExplanation(rightAnswerExplanation);
		answer.setGrading(grading);
		answer.setIsStricky(isStricky);
		List<Answer> answerObj = new ArrayList<Answer>();
		answerObj.add(answer);
		QuestionDTO questionDTO = new QuestionDTO();
		questionDTO.setAnswer(answerObj);
		questionDTO.setTitle(title);
		questionDTO.setQuestionType(questionType);
		questionDTO.setContent(content);
		questionDTO.setCategoryId(categoryId);
		questionDTO.setTag(tag);
		questionDTO.setLevelId(levelId);
		questionDTO.setSkillPoints(skillPoints);
		questionDTO.setScore(score);
		questionDTO.setDuration(duration);
		questionDTO.setStatus(status);
		questionDTO.setIsImported(isImported);

		
			questionService.saveQuestionAnswer(questionDTO);
		
	}

	@Test(expected = ServiceException.class)
	public void invalidCategoryIdTest()throws ServiceException {
		Answer answer = new Answer();
		answer.setOption("someanswer");
		answer.setIsRightAnswer(true);
		answer.setRightAnswerExplanation("Explanation");
		answer.setGrading("2");
		answer.setIsStricky(true);
		List<Answer> answerObj = new ArrayList<Answer>();
		answerObj.add(answer);
		QuestionDTO questionDTO = new QuestionDTO();
		questionDTO.setAnswer(answerObj);
		questionDTO.setTitle("Jquery");
		questionDTO.setQuestionType(QuestionType.BestChoice);
		questionDTO.setContent("@^");
		questionDTO.setCategoryId("h");
		questionDTO.setTag("Query");
		questionDTO.setLevelId("1");
		questionDTO.setSkillPoints("5");
		questionDTO.setScore("4");
		questionDTO.setDuration("2:3:2");
		questionDTO.setStatus(true);
		questionDTO.setIsImported(true);

		
			questionService.saveQuestionAnswer(questionDTO);
		
	}
	
	@Test(expected = ServiceException.class)
	public void invalidTagTest() throws ServiceException {
		Answer answer = new Answer();
		answer.setOption("someanswer");
		answer.setIsRightAnswer(true);
		answer.setRightAnswerExplanation("Explanation");
		answer.setGrading("2");
		answer.setIsStricky(true);
		List<Answer> answerObj = new ArrayList<Answer>();
		answerObj.add(answer);
		QuestionDTO questionDTO = new QuestionDTO();
		questionDTO.setAnswer(answerObj);
		questionDTO.setTitle("Jquery");
		questionDTO.setQuestionType(QuestionType.BestChoice);
		questionDTO.setContent("What is jquery");
		questionDTO.setCategoryId("5");
		questionDTO.setTag("*^&*");
		questionDTO.setLevelId("1");
		questionDTO.setSkillPoints("5");
		questionDTO.setScore("4");
		questionDTO.setDuration("2:3:2");
		questionDTO.setStatus(true);
		questionDTO.setIsImported(true);

		
			questionService.saveQuestionAnswer(questionDTO);
		
	}

	
	@Test(expected = ServiceException.class)
	public void invalidLevelIdTest() throws ServiceException  {
		Answer answer = new Answer();
		answer.setOption("someanswer");
		answer.setIsRightAnswer(true);
		answer.setRightAnswerExplanation("Explanation");
		answer.setGrading("2");
		answer.setIsStricky(true);
		List<Answer> answerObj = new ArrayList<Answer>();
		answerObj.add(answer);
		QuestionDTO questionDTO = new QuestionDTO();
		questionDTO.setAnswer(answerObj);
		questionDTO.setTitle("Jquery");
		questionDTO.setQuestionType(QuestionType.BestChoice);
		questionDTO.setContent("what is Json");
		questionDTO.setCategoryId("3");
		questionDTO.setTag("Query");
		questionDTO.setLevelId("jh");
		questionDTO.setSkillPoints("5");
		questionDTO.setScore("4");
		questionDTO.setDuration("2:3:2");
		questionDTO.setStatus(true);
		questionDTO.setIsImported(true);

	
			questionService.saveQuestionAnswer(questionDTO);
		
	}
	
	
	
	@Test(expected = ServiceException.class)
	public void invalidSkillPointsTest() throws ServiceException  {
		Answer answer = new Answer();
		answer.setOption("someanswer");
		answer.setIsRightAnswer(true);
		answer.setRightAnswerExplanation("Explanation");
		answer.setGrading("2");
		answer.setIsStricky(true);
		List<Answer> answerObj = new ArrayList<Answer>();
		answerObj.add(answer);
		QuestionDTO questionDTO = new QuestionDTO();
		questionDTO.setAnswer(answerObj);
		questionDTO.setTitle("Jquery");
		questionDTO.setQuestionType(QuestionType.BestChoice);
		questionDTO.setContent("what is Json");
		questionDTO.setCategoryId("3");
		questionDTO.setTag("Query");
		questionDTO.setLevelId("2");
		questionDTO.setSkillPoints("^");
		questionDTO.setScore("4");
		questionDTO.setDuration("2:3:2");
		questionDTO.setStatus(true);
		questionDTO.setIsImported(true);

		
			questionService.saveQuestionAnswer(questionDTO);
		
	}

	
	
	@Test(expected = ServiceException.class)
	public void invalidScoreTest() throws ServiceException  {
		Answer answer = new Answer();
		answer.setOption("someanswer");
		answer.setIsRightAnswer(true);
		answer.setRightAnswerExplanation("Explanation");
		answer.setGrading("2");
		answer.setIsStricky(true);
		List<Answer> answerObj = new ArrayList<Answer>();
		answerObj.add(answer);
		QuestionDTO questionDTO = new QuestionDTO();
		questionDTO.setAnswer(answerObj);
		questionDTO.setTitle("Jquery");
		questionDTO.setQuestionType(QuestionType.BestChoice);
		questionDTO.setContent("what is Json");
		questionDTO.setCategoryId("3");
		questionDTO.setTag("Query");
		questionDTO.setLevelId("3");
		questionDTO.setSkillPoints("5");
		questionDTO.setScore("%");
		questionDTO.setDuration("2:3:2");
		questionDTO.setStatus(true);
		questionDTO.setIsImported(true);

		
			questionService.saveQuestionAnswer(questionDTO);
		
	}

	
	
	@Test(expected = ServiceException.class)
	public void invalidDurationTest()throws ServiceException {
		Answer answer = new Answer();
		answer.setOption("someanswer");
		answer.setIsRightAnswer(true);
		answer.setRightAnswerExplanation("Explanation");
		answer.setGrading("2");
		answer.setIsStricky(true);
		List<Answer> answerObj = new ArrayList<Answer>();
		answerObj.add(answer);
		QuestionDTO questionDTO = new QuestionDTO();
		questionDTO.setAnswer(answerObj);
		questionDTO.setTitle("Jquery");
		questionDTO.setQuestionType(QuestionType.BestChoice);
		questionDTO.setContent("what is Json");
		questionDTO.setCategoryId("3");
		questionDTO.setTag("Query");
		questionDTO.setLevelId("3");
		questionDTO.setSkillPoints("5");
		questionDTO.setScore("4");
		questionDTO.setDuration(".");
		questionDTO.setStatus(true);
		questionDTO.setIsImported(true);

	
			questionService.saveQuestionAnswer(questionDTO);
		
	}

	
	
}
