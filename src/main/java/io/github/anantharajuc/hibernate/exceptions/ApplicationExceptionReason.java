package io.github.anantharajuc.hibernate.exceptions;

import io.github.anantharajuc.hibernate.exceptions.policy.ApplicationExceptionPolicy;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Defines the application exception reasons.
 */
@Getter
@AllArgsConstructor
public enum ApplicationExceptionReason implements ApplicationExceptionPolicy {

    BEAN_PROPERTY_NOT_EXISTS("Property '%s' for object '%s' doesn't exists");

    private final String code = ApplicationExceptionReason.class.getSimpleName();
    private final String message;


}
