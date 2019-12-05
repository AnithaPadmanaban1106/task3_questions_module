package com.revature.revaturequestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.revature.revaturequestion.dao.QuestionAnswerDAOImpl;
import com.revature.revaturequestion.dto.QuestionAnswerDTO;
import com.revature.revaturequestion.exception.ServiceException;
import com.revature.revaturequestion.model.Answer;
import com.revature.revaturequestion.model.Question;

@Service
public class QuestionAnswerService {
	@Autowired
	QuestionAnswerDAOImpl questionAnswerDAOImpl;

	@Transactional
	public boolean saveQuestionAnswer(QuestionAnswerDTO questionAnswerDTO) throws ServiceException {

		Answer answer = new Answer();
		Question question = new Question();
		Boolean result;

		try {
			answer.setQuestionId(questionAnswerDTO.getQuestionId());
			answer.setOption(questionAnswerDTO.getOption());
			answer.setIsRightAnswer(questionAnswerDTO.getIsRightAnswer());
			answer.setRightAnswerExplanation(questionAnswerDTO.getRightAnswerExplanation());
			answer.setGrading(questionAnswerDTO.getGrading());
			answer.setIsStricky(questionAnswerDTO.getIsStricky());

			question.setTitle(questionAnswerDTO.getTitle());
			question.setQuestionType(questionAnswerDTO.getQuestionType());
			question.setContent(questionAnswerDTO.getContent());
			question.setCategoryId(questionAnswerDTO.getCategoryId());
			question.setTag(questionAnswerDTO.getTag());
			question.setLevelId(questionAnswerDTO.getLevelId());
			question.setSkillPoints(questionAnswerDTO.getSkillPoints());
			question.setScore(questionAnswerDTO.getScore());
			question.setDuration(questionAnswerDTO.getDuration());
			question.setStatus(questionAnswerDTO.getStatus());
			question.setIsImported(questionAnswerDTO.getIsImported());
			result = questionAnswerDAOImpl.saveQuestionAnswer(question, answer);
		} catch (Exception e) {
			throw new ServiceException("Unable to create questions");
		}
		return result;

	}

	public boolean deleteQuestion(QuestionAnswerDTO questionAnswerDTO) throws ServiceException {

		Question question = new Question();
		Boolean result;
		try {
			question.setQuestionId(questionAnswerDTO.getQuestionId());
			result = questionAnswerDAOImpl.deleteQuestion(question);
		} catch (Exception e) {
			throw new ServiceException("Unable to delete questions");
		}
		return result;
	}
}
