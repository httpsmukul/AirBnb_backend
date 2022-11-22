package com.air.demo.exceptionHandler;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

//@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {


//    @org.springframework.web.bind.annotation.ExceptionHandler(value = {Exception.class})
//    public ResponseEntity handleAnyException(Exception ex, WebRequest request){
//        ErrorMessage errorMessage = new ErrorMessage(erroMessageDescription);
//        errorMessage.setMessage("yes something went wrong");
//        errorMessage.setLocalDateTime(LocalDateTime.now());
//        return new ResponseEntity<>(errorMessage,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
//    }


    @org.springframework.web.bind.annotation.ExceptionHandler(value = ServiceException.class)
    public ResponseEntity<Object> handleServiceException(ServiceException ex){

        String erroMessageDescription = ex.getMessage();

        ErrorMessage errorMessage = new ErrorMessage(erroMessageDescription);

        return new ResponseEntity<Object>(errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);


    }




}


