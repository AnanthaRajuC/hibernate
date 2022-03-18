package io.github.anantharajuc.hibernate.domain.model.project.dto;

import io.github.anantharajuc.hibernate.domain.model.project.Address;
import io.github.anantharajuc.hibernate.domain.model.project.AuditEntity;
import io.github.anantharajuc.hibernate.domain.model.project.Person;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@Getter
public class StudentDTO /*extends AuditEntity*/ /*implements Serializable */{
    private final Long id;
    private final Date createdDate;
    private final Date lastModifiedDate;
    private final String email;
    private final Set<String> images;
    private final List<String> education;
    private final Map<String, String> parents;
    private final Set<String> subjects;
    private final Person person;
    private final Address homeAddress;
    private final Address billingAddress;

    @Builder
    public StudentDTO(Long id, Date createdDate, Date lastModifiedDate, String email, Set<String> images, List<String> education, Map<String, String> parents, Set<String> subjects, Address homeAddress, Address billingAddress, Person person) {
        this.id = id;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.person = person;
        this.email = email;
        this.images = images;
        this.education = education;
        this.parents = parents;
        this.subjects = subjects;
        this.homeAddress = homeAddress;
        this.billingAddress = billingAddress;
    }
}
