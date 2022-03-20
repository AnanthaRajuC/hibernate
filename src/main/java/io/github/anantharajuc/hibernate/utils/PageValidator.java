package io.github.anantharajuc.hibernate.utils;

import io.github.anantharajuc.hibernate.exceptions.InvalidPageIndexException;
import io.github.anantharajuc.hibernate.exceptions.InvalidPageSizeException;
import org.apache.commons.lang3.Validate;

public class PageValidator {
    public PageValidator() {
    }

    public static void validate(Integer page, Integer size) {
        Validate.notNull(page, "Page index must not be null", new Object[0]);
        Validate.notNull(size, "Page size must not be null", new Object[0]);
        if (page < 1) {
            throw new InvalidPageIndexException("Page index must not be less than one");
        } else if (size < 1) {
            throw new InvalidPageSizeException("Page size must not be less than one");
        } else if (size > 100) {
            throw new InvalidPageSizeException("Page size must not be greater than 100");
        }
    }
}
