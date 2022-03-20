package io.github.anantharajuc.hibernate.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

public final class JPAUtility {
    private JPAUtility() {
    }

    public static Sort convertToSort(String sortBy, String direction) {
        return null != sortBy && !sortBy.isEmpty() ? Sort.by(direction == null ? Direction.ASC : Direction.fromString(direction), StringUtils.split(sortBy, ",")) : Sort.unsorted();
    }
}
