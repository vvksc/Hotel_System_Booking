package com.hotelservice.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



public class ExceptionHandler {
	@org.springframework.web.bind.annotation.ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<Object, Object>> resourcenotfoundexceptionhandler(ResourceNotFoundException ex){
		Map<Object, Object> m1=new HashMap<Object, Object>();
		m1.put("message", ex.getMessage());
		m1.put("success", false);
		m1.put("status", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(m1,HttpStatus.BAD_REQUEST);
		
	}
}
