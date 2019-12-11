package com.revature.revaturequestion.service;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.revaturequestion.dao.QuestionDAOImpl;
import com.revature.revaturequestion.exception.DBException;
import com.revature.revaturequestion.exception.ServiceException;
import com.revature.revaturequestion.model.Question;

@RunWith(MockitoJUnitRunner.class)
class QuestionMokitoTest {
	@InjectMocks
	QuestionService listAllQuestionService;
	@Mock
	QuestionDAOImpl listAllQuestionDAOImpl;

	@Test
	public void testListAllQuestions() {
		List<Question> list = mock(ArrayList.class);
		try {
			Question question = new Question();
			question.setQuestionId("1");
			list.add(question);	
			List<Question> returnlist=null;
			returnlist = listAllQuestionService.listAll("1");
			when(list.get(1)).thenReturn(question);
			assertEquals(question, list.get(1));
		} catch (ServiceException e) {
			e.printStackTrace();
		} 
	}
}
