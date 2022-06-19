package io.github.anantharajuc.hibernate.domain.model.project.common;

import io.github.anantharajuc.hibernate.domain.model.project.common.enums.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.Map;

@FieldDefaults(level= AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@SuperBuilder
public class Person {

    @Column(name="first_name", nullable = false)
    @Length(message="First name must be between 3 and 50 characters.", min = 3, max = 50)
    @NotBlank(message="First name cannot be blank.")
    String firstName;

    @Column(name="last_name")
    @Length(message="Last name must be between 3 and 50 characters.", min = 3, max = 50)
    @NotBlank(message="Last name cannot be blank.")
    String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name="gender")
    Gender gender;

    /*@ElementCollection
    @CollectionTable(name="parents")
    @Column(name="parent_name")
    @MapKeyColumn(name="parent")
    Map<String, String> parents = new HashMap<>();*/
}
