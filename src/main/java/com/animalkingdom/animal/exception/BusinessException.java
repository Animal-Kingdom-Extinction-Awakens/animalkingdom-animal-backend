package com.animalkingdom.animal.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class BusinessException extends ResponseStatusException {

    public BusinessException(HttpStatusCode status) {
        super(status);
    }

    public BusinessException(HttpStatusCode status, String reason) {
        super(status, reason);
    }
}
