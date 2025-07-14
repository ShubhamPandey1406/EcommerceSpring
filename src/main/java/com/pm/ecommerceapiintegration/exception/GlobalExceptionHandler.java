package com.pm.ecommerceapiintegration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(productNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFoundException(productNotFoundException ex){
       // return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The new message is " + ex.getMessage());

        ErrorResponse err= new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), LocalDateTime.now() );

        return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorResponse>handleGenericException(Exception ex)
//    {
//        ErrorResponse err= new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"An unexpected error occured. We are working on it", LocalDateTime.now() );
//
//    return new ResponseEntity<>(err,HttpStatus.INTERNAL_SERVER_ERROR);}
}
