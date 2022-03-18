package io.github.anantharajuc.hibernate.interfaces.facade.impl;

import io.github.anantharajuc.hibernate.application.StudentService;
import io.github.anantharajuc.hibernate.domain.model.project.Student;
import io.github.anantharajuc.hibernate.domain.model.project.dto.StudentDTO;
import io.github.anantharajuc.hibernate.interfaces.facade.StudentFacade;
import io.github.anantharajuc.hibernate.interfaces.facade.assembler.StudentDTOAssembler;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StudentFacadeImpl implements StudentFacade {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentDTOAssembler studentDTOAssembler;

    @Override
    public StudentDTO getStudentById(Long studentId) {
        final Student student = studentService.getStudentById(studentId);
        return studentDTOAssembler.toDTO(student);
    }

    @Override
    public Long createStudent(StudentDTO studentDTO) {
        Student student = studentDTOAssembler.fromDTO(studentDTO);
        student = studentService.createStudent(student);
        return student.getId();
    }
}
