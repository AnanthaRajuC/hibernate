package io.github.anantharajuc.hibernate.domain.model.project.dto;

import io.github.anantharajuc.hibernate.domain.model.project.common.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Data
@Getter
@SuperBuilder
@AllArgsConstructor
public class StudentDTO extends AuditEntity{
    private final Person person;
    private final Contact contact;
    private final Address homeAddress;
    private final Address billingAddress;
    private final Course course;
}
