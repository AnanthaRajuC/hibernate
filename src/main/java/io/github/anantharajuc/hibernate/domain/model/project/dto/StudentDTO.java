package io.github.anantharajuc.hibernate.domain.model.project.dto;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
public class StudentDTO implements Serializable {
    private final Long id;
    @Length(message = "First name must be between 3 and 50 characters.", min = 3, max = 50)
    @NotBlank(message = "First name cannot be blank.")
    private final String firstName;
    @Length(message = "Last name must be between 3 and 50 characters.", min = 3, max = 50)
    @NotBlank(message = "Last name cannot be blank.")
    private final String lastName;
    @Email
    @Length(message = "Must be a valid email id between 3 and 50 characters.", min = 3, max = 50)
    @NotNull(message = "Email cannot be blank.")
    private final String email;
    private final Set<String> images;
    private final List<String> education;

    @Builder
    public StudentDTO(Long id, String firstName, String lastName, String email, Set<String> images, List<String> education) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.images = images;
        this.education = education;
    }
}
