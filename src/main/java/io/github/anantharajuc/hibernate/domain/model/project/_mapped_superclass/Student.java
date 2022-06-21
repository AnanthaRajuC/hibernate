package io.github.anantharajuc.hibernate.domain.model.project._mapped_superclass;

import io.github.anantharajuc.hibernate.domain.model.project.common.*;
import io.github.anantharajuc.hibernate.domain.model.project.common.audit.AuditEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@FieldDefaults(level=AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="student", schema="jhac")
@SuperBuilder
@EntityListeners(AuditingEntityListener.class)
@Where(clause = "is_active = 1")
public class Student extends AuditEntity {

    @Embedded
    Person person;

    @Embedded
    Contact contact;

    @Embedded
    Address homeAddress;

    @AttributeOverrides({
            @AttributeOverride(name="street", column=@Column(name="billing_street")),
            @AttributeOverride(name="city", column=@Column(name="billing_city")),
            @AttributeOverride(name="zipcode", column=@Column(name="billing_zipcode"))})
    @Embedded
    Address billingAddress;

    @Embedded
    Course course;

    public void addSubjects(List<String> subjects){
        if (!subjects.isEmpty())
            this.getCourse().getSubjects().addAll(subjects);
    }
}