package io.github.anantharajuc.hibernate.exceptions;

import org.springframework.http.HttpStatus;

public class AbstractUncheckedException extends RuntimeException implements BaseException{
    private String code;
    private HttpStatus status;

    /** @deprecated */
    @Deprecated
    protected AbstractUncheckedException(final String code, final String message, final Integer status) {
        super(message);
        this.code = code;
        this.status = HttpStatus.valueOf(status);
    }

    protected AbstractUncheckedException(final String message, final BaseError error) {
        super(message);
        this.code = error.code();
        this.status = error.status();
    }

    /** @deprecated */
    @Deprecated
    protected AbstractUncheckedException(final String code, final String message, final Integer status, final Throwable cause) {
        super(message, cause);
        this.code = code;
        this.status = HttpStatus.valueOf(status);
    }

    protected AbstractUncheckedException(final String message, final BaseError error, final Throwable cause) {
        super(message, cause);
        this.code = error.code();
        this.status = error.status();
    }

    public String getCode() {
        return this.code;
    }

    public HttpStatus getStatus() {
        return this.status;
    }
}
