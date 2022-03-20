package io.github.anantharajuc.hibernate.domain.model.project._mapped_superclass;

import io.github.anantharajuc.hibernate.domain.model.project.common.Address;
import io.github.anantharajuc.hibernate.domain.model.project.common.audit.AuditEntity;
import io.github.anantharajuc.hibernate.domain.model.project.common.Contact;
import io.github.anantharajuc.hibernate.domain.model.project.common.Person;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="instructor", schema="jhac")
@SuperBuilder
@EntityListeners(AuditingEntityListener.class)
public class Instructor extends AuditEntity {

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
}
