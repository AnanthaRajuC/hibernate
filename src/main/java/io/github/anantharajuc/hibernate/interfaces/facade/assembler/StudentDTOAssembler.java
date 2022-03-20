package io.github.anantharajuc.hibernate.interfaces.facade.assembler;

import io.github.anantharajuc.hibernate.domain.model.project.Student;
import io.github.anantharajuc.hibernate.domain.model.project.common.Contact;
import io.github.anantharajuc.hibernate.domain.model.project.common.Course;
import io.github.anantharajuc.hibernate.domain.model.project.common.Person;
import io.github.anantharajuc.hibernate.domain.model.project.dto.StudentDTO;
import org.springframework.stereotype.Component;

@Component
public class StudentDTOAssembler{
    public Student fromDTO(final StudentDTO studentDTO){
        return Student.builder()
                .id(studentDTO.getId())
                .person(studentDTO.getPerson())

                /*.person(Person.builder()
                        .firstName(studentDTO.getPerson().getFirstName())
                        .lastName(studentDTO.getPerson().getLastName())
                        .gender(studentDTO.getPerson().getGender())
                        .parents(studentDTO.getPerson().getParents())
                        .build())*/

                .contact(Contact.builder().email(studentDTO.getContact().getEmail()).build())
                /*.email(studentDTO.getEmail())*/
                .course(studentDTO.getCourse())
                /*.images(studentDTO.getImages())*/
                /*.education(studentDTO.getEducation())*/
                /*.parents(studentDTO.getParents())*/
                /*.subjects(studentDTO.getSubjects())*/
                .homeAddress(studentDTO.getHomeAddress())
                .billingAddress(studentDTO.getBillingAddress())
                .build();
    }

    public StudentDTO toDTO(final Student student){
        return StudentDTO.builder()
                .id(student.getId())
                .createdDate(student.getCreatedDate())
                .lastModifiedDate(student.getLastModifiedDate())
                .person(student.getPerson())
                .contact(student.getContact())
                .course(student.getCourse())
                .homeAddress(student.getHomeAddress())
                .billingAddress(student.getBillingAddress())
                .build();
    }
}
