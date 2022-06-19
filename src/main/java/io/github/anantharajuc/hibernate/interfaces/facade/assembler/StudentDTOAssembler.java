package io.github.anantharajuc.hibernate.interfaces.facade.assembler;

import io.github.anantharajuc.hibernate.domain.model.project._mapped_superclass.Student;
import io.github.anantharajuc.hibernate.domain.model.project.common.Contact;
import io.github.anantharajuc.hibernate.domain.model.project.dto.StudentDTO;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class StudentDTOAssembler{
    public Student fromDTO(final StudentDTO studentDTO){
        if(studentDTO == null){
            return null;
        }

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
        if(student == null){
            return null;
        }

        return StudentDTO.builder()
                .id(student.getId())
                .uuid(student.getUuid())
                .createdDate(student.getCreatedDate())
                .lastModifiedDate(student.getLastModifiedDate())
                .person(student.getPerson())
                .contact(student.getContact())
                .homeAddress(student.getHomeAddress())
                .billingAddress(student.getBillingAddress())
                .course(student.getCourse())
                .build();
    }

    public Set<StudentDTO> toDTOs(Set<Student> students){
        if(students == null || students.isEmpty()){
            return Collections.emptySet();
        }

        return students.stream()
                .map(this::toDTO)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Set<Student> fromDTOs(Set<StudentDTO> studentDTOs){
        if (studentDTOs == null || studentDTOs.isEmpty()) {
            return Collections.emptySet();
        }

        return studentDTOs.stream().map(this::fromDTO).collect(Collectors.toSet());
    }
}
