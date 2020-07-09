package com.zealep.api.salesbackend.exception;

public class MailException extends com.zealep.app.deliverybackend.exceptions.ConflictException {
    private static final String DESCRIPTION = "Mail exception";

    public MailException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

}