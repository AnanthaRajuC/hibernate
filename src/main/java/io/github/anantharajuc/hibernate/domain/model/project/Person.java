package io.github.anantharajuc.hibernate.domain.model.project;

import io.github.anantharajuc.hibernate.domain.model.project.enums.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

@FieldDefaults(level= AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Person {

    @Column(name = "first_name", nullable = false)
    @Length(message = "First name must be between 3 and 50 characters.", min = 3, max = 50)
    @NotBlank(message = "First name cannot be blank.")
    String firstName;

    @Column(name = "last_name")
    @Length(message = "Last name must be between 3 and 50 characters.", min = 3, max = 50)
    @NotBlank(message = "Last name cannot be blank.")
    String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    Gender gender;
}
