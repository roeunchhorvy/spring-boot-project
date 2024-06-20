package com.devkh.courseservice.exceptionn;

public class InternalServerErrorException extends RuntimeException{
    public InternalServerErrorException(String message) {
        super(message);
    }

    public InternalServerErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
