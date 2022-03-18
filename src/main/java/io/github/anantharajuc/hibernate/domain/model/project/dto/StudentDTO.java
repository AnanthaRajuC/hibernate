package io.github.anantharajuc.hibernate.domain.model.project.dto;

import io.github.anantharajuc.hibernate.domain.model.project.Address;
import io.github.anantharajuc.hibernate.domain.model.project.AuditEntity;
import io.github.anantharajuc.hibernate.domain.model.project.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@Getter
@SuperBuilder
@AllArgsConstructor
public class StudentDTO extends AuditEntity{

    private final String email;
    private final Set<String> images;
    private final List<String> education;
    private final Map<String, String> parents;
    private final Set<String> subjects;
    private final Person person;
    private final Address homeAddress;
    private final Address billingAddress;
}
