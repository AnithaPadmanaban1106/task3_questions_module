package com.revature.revaturequestion.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.revaturequestion.dto.Message;
import com.revature.revaturequestion.exception.ServiceException;
import com.revature.revaturequestion.model.Question;
import com.revature.revaturequestion.service.ListAllQuestionService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping

public class ListAllController {
	@Autowired
	ListAllQuestionService listAllQuestionService;
	
	@PostMapping("listAllQuestion")

	@ApiOperation("listAllQuestionApi")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Message.class),
			@ApiResponse(code = 400, message = "Failure") })
	public ResponseEntity<?> listAll()throws ServiceException, SQLException {
		String errorMessage = null;

		List<Question> result=null;
		try {

			result = listAllQuestionService.listAll();
			return new ResponseEntity<>(result, HttpStatus.OK);

		} catch (ServiceException e) {
			errorMessage = e.getMessage();
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		}

	}
}

