package com.revature.revaturequestion.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.revaturequestion.dto.Message;
import com.revature.revaturequestion.dto.QuestionAnswerDTO;
import com.revature.revaturequestion.exception.ServiceException;
import com.revature.revaturequestion.service.QuestionAnswerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping
public class QuestionAnswerContoller {
	@Autowired
	QuestionAnswerService questionAnswerService;
	
	@PostMapping("questionAnswer")
	// @ResponseStatus(code = HttpStatus.OK)
	@ApiOperation("questionAnswerApi")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Message.class),
			@ApiResponse(code = 400, message = "Failure") })
	public ResponseEntity<?> createQuestion(@RequestBody QuestionAnswerDTO questionAnswerDTO)
			throws ServiceException, SQLException {
		String errorMessage = null;
		
		Boolean result=false;
		try {
			
			result = questionAnswerService.saveQuestionAnswer(questionAnswerDTO);
			return new ResponseEntity<>(result, HttpStatus.OK);

		} catch (ServiceException e) {
			errorMessage = e.getMessage();
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		}

		
}
	
	
	
	@PostMapping("delete")
	// @ResponseStatus(code = HttpStatus.OK)
	@ApiOperation("deleteApi")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Message.class),
			@ApiResponse(code = 400, message = "Failure") })
	public ResponseEntity<?> deleteQuestion(@RequestBody QuestionAnswerDTO questionAnswerDTO)
			throws ServiceException, SQLException {
		String errorMessage = null;
		
		Boolean result=false;
		try {
			
			result = questionAnswerService.deleteQuestion(questionAnswerDTO);
			return new ResponseEntity<>(result, HttpStatus.OK);

		} catch (ServiceException e) {
			errorMessage = e.getMessage();
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		}

		
}
	
}
