package com.param.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionAdvice extends ResponseEntityExceptionHandler{

  @ExceptionHandler(EmployeeNotFoundException.class)
  //@ResponseStatus(HttpStatus.NOT_FOUND)
  ResponseEntity<Object> employeeNotFoundHandler(EmployeeNotFoundException ex, WebRequest request) {
	  EmployeeExceptionResponse exceptionResponse= new EmployeeExceptionResponse(new Date(), ex.getMessage(),request.getDescription(false));
    return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
  }
 @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	  EmployeeExceptionResponse exceptionResponse= new EmployeeExceptionResponse(new Date(), "Validation Failed !!",ex.getBindingResult().toString());
    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
  }
}
