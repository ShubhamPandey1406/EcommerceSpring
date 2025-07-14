package com.pm.ecommerceapiintegration.exception;

public class productNotFoundException extends RuntimeException {

    public productNotFoundException(String message) {
        super(message);
    }
}


//Why wxtending RuntimeExceptions

//Marks it as an unchecked Exception. Callers are not forced to declare it or catch it