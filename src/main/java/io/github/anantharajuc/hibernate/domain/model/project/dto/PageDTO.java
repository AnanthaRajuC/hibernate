package io.github.anantharajuc.hibernate.domain.model.project.dto;

import io.github.anantharajuc.hibernate.domain.model.project.common.AuditEntity;

import java.util.Set;

public final class PageDTO<T extends AuditEntity> {
    private Set<T> elements;
    private boolean hasNext;
    private long totalElements;

    public PageDTO(Set<T> elements, boolean hasNext) {
        this.elements = elements;
        this.hasNext = hasNext;
    }

    public PageDTO(Set<T> elements, boolean hasNext, long totalElements) {
        this.elements = elements;
        this.hasNext = hasNext;
        this.totalElements = totalElements;
    }

    public Set<T> getElements() {
        return this.elements;
    }

    public boolean hasNext() {
        return this.hasNext;
    }

    public long getTotalElements() {
        return this.totalElements;
    }
}
