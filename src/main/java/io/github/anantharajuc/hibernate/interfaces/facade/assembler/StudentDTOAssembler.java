package io.github.anantharajuc.hibernate.interfaces.facade.assembler;

import io.github.anantharajuc.hibernate.domain.model.project._mapped_superclass.Student;
import io.github.anantharajuc.hibernate.domain.model.project.common.Contact;
import io.github.anantharajuc.hibernate.domain.model.project.dto.StudentDTO;
import org.springframework.stereotype.Component;

@Component
public class StudentDTOAssembler{
    public Student fromDTO(final StudentDTO studentDTO){
        return Student.builder()
                .id(studentDTO.getId())
                .person(studentDTO.getPerson())
                .contact(Contact.builder()
                        .email(studentDTO.getContact().getEmail())
                        .phone(studentDTO.getContact().getPhone())
                        .build())
                .homeAddress(studentDTO.getHomeAddress())
                .billingAddress(studentDTO.getBillingAddress())
                .course(studentDTO.getCourse())
                .build();
    }

    public StudentDTO toDTO(final Student student){
        return StudentDTO.builder()
                .id(student.getId())
                .createdDate(student.getCreatedDate())
                .lastModifiedDate(student.getLastModifiedDate())
                .person(student.getPerson())
                .contact(student.getContact())
                .homeAddress(student.getHomeAddress())
                .billingAddress(student.getBillingAddress())
                .course(student.getCourse())
                .build();
    }
}
