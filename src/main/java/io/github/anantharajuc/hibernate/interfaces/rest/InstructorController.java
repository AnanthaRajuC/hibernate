package io.github.anantharajuc.hibernate.interfaces.rest;

import io.github.anantharajuc.hibernate.domain.model.project.dto.InstructorDTO;
import io.github.anantharajuc.hibernate.domain.model.project.dto.PageDTO;
import io.github.anantharajuc.hibernate.interfaces.facade.InstructorFacade;
import io.github.anantharajuc.hibernate.utils.PageValidator;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Log4j2
@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {
    private static final java.util.logging.Logger logSuccess = java.util.logging.Logger.getLogger(InstructorController.class.getName());

    @Autowired
    private InstructorFacade instructorFacade;

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/{instructorId}")
    public InstructorDTO getInstructorById(@PathVariable("instructorId") Long instructorId) {
        logSuccess.info("Instructor controller");
        return instructorFacade.getInstructorById(instructorId);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("")
    public Long createInstructor(@RequestBody InstructorDTO instructorDTO) {
        return instructorFacade.createInstructor(instructorDTO);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PutMapping
    public ResponseEntity<List<InstructorDTO>> updateInstructor(@RequestBody List<InstructorDTO> instructorDTOList){
        return new ResponseEntity<>(instructorFacade.updateInstructor(instructorDTOList),HttpStatus.OK);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("")
    public ResponseEntity<Set<InstructorDTO>> getInstructors(
            @RequestParam Integer page,
            @RequestParam Integer size,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) String direction) {

        PageValidator.validate(page, size);
        PageDTO<InstructorDTO> result = instructorFacade.getInstructors(page - 1, size, sortBy, direction);
        ResponseEntity<Set<InstructorDTO>> responseEntity;

        if (result.hasNext()) {
            responseEntity = new ResponseEntity<>(result.getElements(), HttpStatus.PARTIAL_CONTENT);
        } else {
            responseEntity = new ResponseEntity<>(result.getElements(), HttpStatus.OK);
        }
        return responseEntity;
    }
}
