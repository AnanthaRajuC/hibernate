package io.github.anantharajuc.hibernate.exceptions;

import org.springframework.http.HttpStatus;

public interface BaseError {
    String code();
    HttpStatus status();
}
