package com.stackroute.userservice.exception;

public class IncorrectPasswordException extends RuntimeException {

    public IncorrectPasswordException(String message){
        super(message);
    }

}

