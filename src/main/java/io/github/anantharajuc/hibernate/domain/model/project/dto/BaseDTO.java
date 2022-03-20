package io.github.anantharajuc.hibernate.domain.model.project.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class BaseDTO {
    private Long appCreatedAt;
    private Long appLastModifiedAt;

    public Long getAppCreatedAt() {
        return this.appCreatedAt;
    }

    public Long getAppLastModifiedAt() {
        return this.appLastModifiedAt;
    }

    protected BaseDTO() {
    }

    protected BaseDTO(final Long appCreatedAt, final Long appLastModifiedAt) {
        this.appCreatedAt = appCreatedAt;
        this.appLastModifiedAt = appLastModifiedAt;
    }
}

