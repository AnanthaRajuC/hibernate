package io.github.anantharajuc.hibernate.application;

import io.github.anantharajuc.hibernate.domain.model.project._mapped_superclass.Instructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface InstructorService {
    Instructor getInstructorById(Long InstructorId);

    Instructor createInstructor(Instructor instructor);

    Page<Instructor> getInstructors(Integer page, Integer size, Sort sort);

    Instructor updateInstructor(Instructor fromDTO);
}
