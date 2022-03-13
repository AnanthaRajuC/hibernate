package io.github.anantharajuc.hibernate.interfaces.facade;

import io.github.anantharajuc.hibernate.domain.model.project.dto.StudentDTO;

public interface StudentFacade {
    StudentDTO getStudentById(Long studentId);

    Long createStudent(StudentDTO studentDTO);
}
