package com.usersservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.usersservice.exception.payload.ApiResponse;
//import org.springframework.web.bind.annotation;

@RestControllerAdvice
public class ExceptionHandler {


	@org.springframework.web.bind.annotation.ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourcenotfoundexceptionhandler(ResourceNotFoundException ex){
		ApiResponse response = ApiResponse.builder()
                .message(ex.getMessage())
                .success(false)
                .status(HttpStatus.BAD_REQUEST)
                .build();
		return new ResponseEntity<ApiResponse>(response ,HttpStatus.BAD_REQUEST);
		
	}
}
