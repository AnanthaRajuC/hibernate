package io.github.anantharajuc.hibernate.interfaces.facade;

import io.github.anantharajuc.hibernate.domain.model.project.dto.PageDTO;
import io.github.anantharajuc.hibernate.domain.model.project.dto.StudentDTO;

import java.util.List;

public interface StudentFacade {
    StudentDTO getStudentById(Long studentId);

    Long createStudent(StudentDTO studentDTO);

    PageDTO<StudentDTO> getStudents(Integer page, Integer size, String sortBy, String direction);

    List<StudentDTO> updateStudent(List<StudentDTO> studentDTO);

    List<StudentDTO> getStudentsByIds(List<Long> studentIds);

    void deleteStudentById(Long studentId, String reason);
}
