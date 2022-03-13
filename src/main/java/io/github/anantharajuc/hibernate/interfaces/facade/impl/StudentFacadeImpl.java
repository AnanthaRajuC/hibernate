package io.github.anantharajuc.hibernate.interfaces.facade.impl;

import io.github.anantharajuc.hibernate.application.StudentService;
import io.github.anantharajuc.hibernate.domain.model.project.Student;
import io.github.anantharajuc.hibernate.domain.model.project.dto.StudentDTO;
import io.github.anantharajuc.hibernate.interfaces.facade.StudentFacade;
import io.github.anantharajuc.hibernate.interfaces.facade.assembler.StudentDTOAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
