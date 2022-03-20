package io.github.anantharajuc.hibernate.interfaces.facade;

import io.github.anantharajuc.hibernate.domain.model.project.dto.InstructorDTO;
import io.github.anantharajuc.hibernate.domain.model.project.dto.PageDTO;

import java.util.List;

public interface InstructorFacade {
    InstructorDTO getInstructorById(Long instructorId);

    Long createInstructor(InstructorDTO instructorDTO);

    PageDTO<InstructorDTO> getInstructors(Integer page, Integer size, String sortBy, String direction);

    List<InstructorDTO> updateInstructor(List<InstructorDTO> instructorDTO);
}
