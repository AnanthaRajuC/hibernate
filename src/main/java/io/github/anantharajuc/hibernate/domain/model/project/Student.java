package io.github.anantharajuc.hibernate.domain.model.project;

import io.github.anantharajuc.hibernate.domain.model.project.common.Address;
import io.github.anantharajuc.hibernate.domain.model.project.common.AuditEntity;
import io.github.anantharajuc.hibernate.domain.model.project.common.Person;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.*;

@FieldDefaults(level=AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "student", schema = "jhac")
@SuperBuilder
@EntityListeners(AuditingEntityListener.class)
public class Student extends AuditEntity {

    @Embedded
    Person person;

    @Embedded
    Address homeAddress;

    @AttributeOverrides({
            @AttributeOverride(name="street", column=@Column(name="billing_street")),
            @AttributeOverride(name="city", column=@Column(name="billing_city")),
            @AttributeOverride(name="zipcode", column=@Column(name="billing_zipcode"))})
    @Embedded
    Address billingAddress;

    @Email
    @Column(name = "email")
    @Length(message = "Must be a valid email id between 3 and 50 characters.", min = 3, max = 50)
    @NotNull(message = "Email cannot be blank.")
    String email;

    @ElementCollection
    @CollectionTable(name = "student_images", joinColumns = @JoinColumn(name = "student_id"))
    @Column(name = "file_name")
    Set<String> images = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "student_subjects")
    @OrderBy
    @Column(name = "subject_name")
    Set<String> subjects = new LinkedHashSet<>();

    @ElementCollection
    @CollectionTable(name = "education")
    @Column(name = "education")
    @OrderColumn
    List<String> education = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "parents")
    @Column(name = "parent_name")
    @MapKeyColumn(name = "parent")
    Map<String, String> parents = new HashMap<>();
}