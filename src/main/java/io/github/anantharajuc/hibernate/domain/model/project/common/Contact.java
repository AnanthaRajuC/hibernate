package io.github.anantharajuc.hibernate.domain.model.project.common;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@FieldDefaults(level= AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@SuperBuilder
public class Contact {

    @Email
    @Column(name = "email")
    @Length(message = "Must be a valid email id between 3 and 50 characters.", min = 3, max = 50)
    @NotNull(message = "Email cannot be blank.")
    String email;

    @Column(name = "phone")
    String phone;
}
