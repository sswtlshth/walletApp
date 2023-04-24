package com.wallet.exception;

import java.util.Date;

public class ExceptionResponse {
    private final Date timestamp;
    private final String message;
    private final String details;
    public ExceptionResponse(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
    @Override
    public String toString() {
        return "ExceptionResponse [timestamp=" + timestamp + ", message=" + message + ", details=" + details + "]";
    }
    public Date getTimestamp() {
        return timestamp;
    }
    public String getMessage() {
        return message;
    }
    public String getDetails() {
        return details;
    }
}
