package io.github.anantharajuc.hibernate.domain.model.project;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.*;

@FieldDefaults(level=AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "student", schema = "jhac")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "first_name", nullable = false)
    @Length(message = "First name must be between 3 and 50 characters.", min = 3, max = 50)
    @NotBlank(message = "First name cannot be blank.")
    String firstName;

    @Column(name = "last_name")
    @Length(message = "Last name must be between 3 and 50 characters.", min = 3, max = 50)
    @NotBlank(message = "Last name cannot be blank.")
    String lastName;

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