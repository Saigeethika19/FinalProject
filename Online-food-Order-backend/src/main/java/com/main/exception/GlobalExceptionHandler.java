package com.main.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
    // Handle NumberAlreadyExistsException
	    @ExceptionHandler(NumberAlreadyExitsException.class)
	    public ResponseEntity<ApiResponse> handleNumberAlreadyExistsException(NumberAlreadyExitsException ex) {
	        ApiResponse response = new ApiResponse(ex.getMessage(), false, HttpStatus.CONFLICT);
	        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
	    }
	
	    @ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex)
		{
			Map<String, String>errors=new HashMap<String, String>();
			List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
			allErrors.forEach((error)->{
				String fieldName=((FieldError)error).getField();
				String errorMessage = error.getDefaultMessage();
				System.out.println("Field Name:"+fieldName);
				System.out.println("Error Message:"+errorMessage);
				errors.put(fieldName, errorMessage);
			});
			
			return new ResponseEntity<Map<String,String>>(errors,HttpStatus.BAD_REQUEST);
		}
	    @ExceptionHandler(DataIntegrityViolationException.class)
	    public ResponseEntity<Map<String, String>> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
	        Map<String, String> errors = new HashMap<>();
	        String message = ex.getMessage();
	        ex.printStackTrace();
	        if (message.contains("email")) {
	            errors.put("email", "Email already exists");
	        }
	        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	    }
	
	
	
	
	
	
	
	
	
	
	
	

}
