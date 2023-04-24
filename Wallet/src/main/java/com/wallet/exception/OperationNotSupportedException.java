package com.wallet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class OperationNotSupportedException extends RuntimeException {

    public OperationNotSupportedException(String message) {
        super(message);
    }
}
