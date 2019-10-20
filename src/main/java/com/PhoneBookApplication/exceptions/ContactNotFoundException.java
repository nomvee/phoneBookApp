package com.PhoneBookApplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such contact.")
public class ContactNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ContactNotFoundException(Long contactId) {
        super("Could not find contact '" + contactId + "'.");
    }

}
