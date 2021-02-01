package com.dmitry.gpcoding.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SerialNumberInvalidException extends RuntimeException {
    private ErrorDetails details;

    public SerialNumberInvalidException(String exception) {
        super(exception);
        this.details = new ErrorDetails("serial.number.invalid", "ER003",
                "The serial number entered can include a - z, A - Z, 0 - 9 and hyphen. " +
                        "Please correct your entry.");
    }
}
