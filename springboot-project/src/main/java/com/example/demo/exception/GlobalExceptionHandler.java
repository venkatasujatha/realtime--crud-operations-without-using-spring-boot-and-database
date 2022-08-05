package com.example.demo.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, Object> map = new HashMap<>();

		List<String> errorMessage = ex.getBindingResult().getFieldErrors().stream()
				.map(message -> message.getDefaultMessage()).collect(Collectors.toList());
		map.put("errorMessage", errorMessage);
		map.put("status", HttpStatus.BAD_REQUEST);

		return new ResponseEntity(map, headers, status);
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	public String handleIdNotFoundException(IdNotFoundException exception )
	{
		return exception.getMesssage();
	}
	
	@ExceptionHandler(NameNotFoundException.class)
	public String handleNameNotFoundException(NameNotFoundException exception)
	{
		return exception.getMessage();
		
	}
}
