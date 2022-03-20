package io.github.anantharajuc.hibernate.interfaces.facade.assembler;

import io.github.anantharajuc.hibernate.domain.model.project._mapped_superclass.Instructor;
import io.github.anantharajuc.hibernate.domain.model.project.common.Contact;
import io.github.anantharajuc.hibernate.domain.model.project.dto.InstructorDTO;
import org.springframework.stereotype.Component;

@Component
public class InstructorDTOAssembler {
    public Instructor fromDTO(final InstructorDTO instructorDTO){
        return Instructor.builder()
                .id(instructorDTO.getId())
                .person(instructorDTO.getPerson())
                .contact(Contact.builder()
                        .email(instructorDTO.getContact().getEmail())
                        .phone(instructorDTO.getContact().getPhone())
                        .build())
                .homeAddress(instructorDTO.getHomeAddress())
                .billingAddress(instructorDTO.getBillingAddress())
                .build();
    }

    public InstructorDTO toDTO(final Instructor instructor){
        return InstructorDTO.builder()
                .id(instructor.getId())
                .createdDate(instructor.getCreatedDate())
                .lastModifiedDate(instructor.getLastModifiedDate())
                .person(instructor.getPerson())
                .contact(instructor.getContact())
                .homeAddress(instructor.getHomeAddress())
                .billingAddress(instructor.getBillingAddress())
                .build();
    }
}
