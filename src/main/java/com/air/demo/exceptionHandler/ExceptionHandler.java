package com.air.demo.exceptionHandler;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value= MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request){

        Map<String, String> resp = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach( (error)->{

            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();

            resp.put(fieldName, message);

        });
        return new ResponseEntity<Map<String, String>>(resp,new HttpHeaders(),HttpStatus.BAD_REQUEST);

    }

//    @org.springframework.web.bind.annotation.ExceptionHandler(value = ServiceException.class)
//    public ResponseEntity<Object> handleServiceException(ServiceException ex){
//
//
//        String erroMessageDescription = ex.getMessage();
//
//        ErrorMessage errorMessage = new ErrorMessage(erroMessageDescription, ex.getIndexError());
//
//        return new ResponseEntity<Object>(errorMessage,new HttpHeaders(),ex.getStatus());
//
//    }

}
