package io.github.anantharajuc.hibernate.domain.model.project.common;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.*;

@FieldDefaults(level= AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@SuperBuilder
public class Course {

    @ElementCollection
    @CollectionTable(name="student_images", joinColumns=@JoinColumn(name="student_id"))
    @Column(name = "file_name")
    Set<String> images = new HashSet<>();

    @ElementCollection
    @CollectionTable(name="student_subjects")
    @OrderBy
    @Column(name="subject_name")
    Set<String> subjects = new LinkedHashSet<>();

    @ElementCollection
    @CollectionTable(name = "education")
    @Column(name="education")
    @OrderColumn
    List<String> education = new ArrayList<>();
}
