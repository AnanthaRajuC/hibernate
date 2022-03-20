package io.github.anantharajuc.hibernate.exceptions;

import org.springframework.http.HttpStatus;

public interface BaseException {
    String CODE_ERROR_DUPLICATE = "ERR_PLATFORM_GEN_DUPLICATE";
    String CODE_ERROR_NOT_FOUND = "ERR_PLATFORM_GEN_NOT_FOUND";
    String CODE_ERROR_INVALID_INPUT = "ERR_PLATFORM_GEN_INVALID_INPUT";
    String CODE_ERROR_NOT_SUPPORTED = "ERR_PLATFORM_GEN_NOT_SUPPORTED";
    String CODE_ERROR_DATA_ACCESS = "ERR_PLATFORM_GEN_DATA_ACCESS";
    String CODE_ERROR_MESSAGING = "ERR_PLATFORM_GEN_MESSAGING";
    String CODE_ERROR_SECURITY = "ERR_PLATFORM_GEN_SECURITY";
    String CODE_ERROR_UNKNOWN = "ERR_PLATFORM_GEN_UNKNOWN";

    String getCode();

    HttpStatus getStatus();

    default String getMessage(Throwable e) {
        return e.getMessage();
    }
}
