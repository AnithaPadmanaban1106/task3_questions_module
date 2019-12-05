package com.revature.revaturequestion.validator;

import org.springframework.stereotype.Component;

import com.revature.revaturequestion.dto.MessageConstant;
import com.revature.revaturequestion.dto.QuestionAnswerDTO;
import com.revature.revaturequestion.exception.ValidatorException;
import com.revature.revaturequestion.model.QuestionType;

@Component
public class QuestionValidator {
	public void questionValidate(QuestionAnswerDTO employee) throws ValidatorException {
		int questionId;
		String option;
		Boolean isRightAnswer;
		String rightAnswerExplanation;
		String grading;
		Boolean isStricky;
		String title;
		QuestionType questionType;
		String content;
		int categoryId;
		String tag;
		int levelId;
		int skillPoints;
		Double score;
		String duration;
		Boolean status;
		Boolean isImported;
		if (questionId == 0) {
			throw new ValidatorException(MessageConstant.ROLE_ID);
		}
		if (option == null) {
			throw new ValidatorException(MessageConstant.CREATED_BY_ID);
		}
		if (organizationId == 0) {
			throw new ValidatorException(MessageConstant.ORGANIZATION_ID);
		}
	}
}
