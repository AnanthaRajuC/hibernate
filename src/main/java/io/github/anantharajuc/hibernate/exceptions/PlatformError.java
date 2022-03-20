package io.github.anantharajuc.hibernate.exceptions;

import org.springframework.http.HttpStatus;

public enum PlatformError implements BaseError{

    ERR_PLT_GEN_UNAUTHORIZED("ERR-PLT-GEN-001", HttpStatus.UNAUTHORIZED),
    ERR_PLT_GEN_FORBIDDEN("ERR-PLT-GEN-002", HttpStatus.FORBIDDEN),
    ERR_PLT_GEN_SECURITY("ERR-PLT-GEN-003", HttpStatus.FORBIDDEN),
    ERR_PLT_GEN_INVALID_REQUEST("ERR-PLT-GEN-101", HttpStatus.BAD_REQUEST),
    ERR_PLT_GEN_UNKNOWN("ERR-PLT-GEN-999", HttpStatus.INTERNAL_SERVER_ERROR);

    private String code;
    private HttpStatus status;

    private PlatformError(String code, HttpStatus status) {
        this.code = code;
        this.status = status;
    }

    public String code() {
        return this.code;
    }

    public HttpStatus status() {
        return this.status;
    }
}
