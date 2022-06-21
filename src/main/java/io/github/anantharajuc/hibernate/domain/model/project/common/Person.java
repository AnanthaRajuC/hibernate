package io.github.anantharajuc.hibernate.domain.model.project.common;

import io.github.anantharajuc.hibernate.domain.model.project.common.enums.Gender;
import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(description = "Person's First Name", example = "John", required = true)
    @Column(name="first_name", nullable = false)
    @Length(message="First name must be between 3 and 50 characters.", min = 3, max = 50)
    @NotBlank(message="First name cannot be blank.")
    String firstName;

    @Schema(description = "Person's Last Name", example = "Doe", required = false)
    @Column(name="last_name", nullable = true)
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
