package com.devkh.courseservice.exceptionn;

public class NullExceptionClass extends RuntimeException {
    private final String title;

    public NullExceptionClass(String message ,String title) {
        super(message);
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
}
