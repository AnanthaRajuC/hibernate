package io.github.anantharajuc.hibernate.exceptions;

import io.github.anantharajuc.hibernate.exceptions.policy.BusinessExceptionPolicy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Defines the business exception reasons.
 */
@Getter
@AllArgsConstructor
public enum BusinessExceptionReason implements BusinessExceptionPolicy {

    STUDENT_NOT_FOUND_BY_EXT_REF("Student not found based on the given external reference", HttpStatus.NOT_FOUND);

    private final String code = BusinessExceptionReason.class.getSimpleName();
    private final String message;
    private final HttpStatus httpStatus;

}
