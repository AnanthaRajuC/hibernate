package io.github.anantharajuc.hibernate.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public abstract class InvalidInputException extends AbstractUncheckedException {
    protected InvalidInputException(final String message) {
        super(message, PlatformError.ERR_PLT_GEN_INVALID_REQUEST);
    }

    protected InvalidInputException(final String message, final Throwable cause) {
        super(message, PlatformError.ERR_PLT_GEN_INVALID_REQUEST, cause);
    }
}
