package io.github.anantharajuc.hibernate.domain.model.project.dto;

import io.github.anantharajuc.hibernate.domain.model.project.common.Address;
import io.github.anantharajuc.hibernate.domain.model.project.common.Contact;
import io.github.anantharajuc.hibernate.domain.model.project.common.Person;
import io.github.anantharajuc.hibernate.domain.model.project.common.audit.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Data
@Getter
@SuperBuilder
@AllArgsConstructor
public class InstructorDTO extends AuditEntity {
    private final Person person;
    private final Contact contact;
    private final Address homeAddress;
    private final Address billingAddress;
}
