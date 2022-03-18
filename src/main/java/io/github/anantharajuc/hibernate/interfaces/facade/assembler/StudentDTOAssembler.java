package io.github.anantharajuc.hibernate.interfaces.facade.assembler;

import io.github.anantharajuc.hibernate.domain.model.project.Student;
import io.github.anantharajuc.hibernate.domain.model.project.dto.StudentDTO;
import org.springframework.stereotype.Component;

@Component
public class StudentDTOAssembler {
    public Student fromDTO(final StudentDTO studentDTO){
        return Student.builder()
                .id(studentDTO.getId())
                .firstName(studentDTO.getFirstName())
                .lastName(studentDTO.getLastName())
                .email(studentDTO.getEmail())
                .images(studentDTO.getImages())
                .education(studentDTO.getEducation())
                .parents(studentDTO.getParents())
                .subjects(studentDTO.getSubjects())
                .homeAddress(studentDTO.getHomeAddress())
                .billingAddress(studentDTO.getBillingAddress())
                .build();
    }

    public StudentDTO toDTO(final Student student){
        return StudentDTO.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .images(student.getImages())
                .education(student.getEducation())
                .parents(student.getParents())
                .subjects(student.getSubjects())
                .homeAddress(student.getHomeAddress())
                .billingAddress(student.getBillingAddress())
                .build();
    }
}
