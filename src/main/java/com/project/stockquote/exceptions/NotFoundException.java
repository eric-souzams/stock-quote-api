package com.project.stockquote.exceptions;

import com.project.stockquote.util.MessageUtils;

public class NotFoundException extends RuntimeException {
    private static final Long serialVersionUID = 1L;

    public NotFoundException() {
        super(MessageUtils.NO_RECORDS_FOUND);
    }

}
