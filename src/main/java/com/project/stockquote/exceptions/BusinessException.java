package com.project.stockquote.exceptions;

public class BusinessException extends RuntimeException {
    private static final Long serialVersionUID = 1L;

    public BusinessException(String message) {
        super(message);
    }
}
