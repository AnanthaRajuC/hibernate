package io.github.anantharajuc.hibernate.interfaces.facade.impl;

import io.github.anantharajuc.hibernate.application.InstructorService;
import io.github.anantharajuc.hibernate.domain.model.project._mapped_superclass.Instructor;
import io.github.anantharajuc.hibernate.domain.model.project.dto.InstructorDTO;
import io.github.anantharajuc.hibernate.domain.model.project.dto.PageDTO;
import io.github.anantharajuc.hibernate.interfaces.facade.InstructorFacade;
import io.github.anantharajuc.hibernate.interfaces.facade.assembler.InstructorDTOAssembler;
import io.github.anantharajuc.hibernate.utils.JPAUtility;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Log4j2
@Component
public class InstructorFacadeImpl implements InstructorFacade {

    @Autowired
    private InstructorService instructorService;

    @Autowired
    private InstructorDTOAssembler instructorDTOAssembler;

    @Override
    public InstructorDTO getInstructorById(Long instructorId) {
        final Instructor instructor = instructorService.getInstructorById(instructorId);
        return instructorDTOAssembler.toDTO(instructor);
    }

    @Override
    public Long createInstructor(InstructorDTO instructorDTO) {
        Instructor instructor = instructorDTOAssembler.fromDTO(instructorDTO);
        instructor = instructorService.createInstructor(instructor);
        return instructor.getId();
    }

    @Override
    public PageDTO<InstructorDTO> getInstructors(Integer page, Integer size, String sortBy, String direction) {
        final Page<Instructor> instructorPage = instructorService.getInstructors(page, size, JPAUtility.convertToSort(sortBy, direction));
        final Set<InstructorDTO> instructorDTOList = instructorPage.get().map(instructorDTOAssembler::toDTO).collect(Collectors.toSet());
        return new PageDTO<>(instructorDTOList, instructorPage.hasNext());
    }

    @Override
    public List<InstructorDTO> updateInstructor(List<InstructorDTO> instructorDTOList) {
        List<Instructor> updatedInstructorList = new ArrayList<>();
        instructorDTOList.forEach(instructorDTO -> updatedInstructorList.add(instructorService.updateInstructor(instructorDTOAssembler.fromDTO(instructorDTO))));
        return updatedInstructorList.stream().map(instructorDTOAssembler::toDTO).collect(Collectors.toList());
    }
}
