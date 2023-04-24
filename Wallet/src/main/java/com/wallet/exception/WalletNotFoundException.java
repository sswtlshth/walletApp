package com.wallet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class WalletNotFoundException extends  RuntimeException{
    public WalletNotFoundException(String message) {
        super(message);
        System.out.println("Expection "+message);
    }

}
