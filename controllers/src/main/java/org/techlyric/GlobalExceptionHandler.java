package org.techlyric;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice 
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(Exception.class) 
	public ResponseEntity handleException(){
		return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
