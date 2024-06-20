package com.devkh.courseservice.exceptionn;

public class NotFoundExceptionClass extends RuntimeException{
    public NotFoundExceptionClass(String message) {
        super(message);
    }
}
