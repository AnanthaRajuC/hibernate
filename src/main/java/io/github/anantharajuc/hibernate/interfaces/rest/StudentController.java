package io.github.anantharajuc.hibernate.interfaces.rest;

import io.github.anantharajuc.hibernate.domain.model.project.dto.PageDTO;
import io.github.anantharajuc.hibernate.domain.model.project.dto.StudentDTO;
import io.github.anantharajuc.hibernate.interfaces.facade.StudentFacade;
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
@RequestMapping("/api/v1/students")
public class StudentController {

    private static final java.util.logging.Logger logSuccess = java.util.logging.Logger.getLogger(StudentController.class.getName());

    @Autowired
    private StudentFacade studentFacade;

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/{studentId}")
    public StudentDTO getStudentById(@PathVariable("studentId") Long studentId) {
        logSuccess.info("Student controller");
        return studentFacade.getStudentById(studentId);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("")
    public Long createStudent(@RequestBody StudentDTO studentDTO) {
        return studentFacade.createStudent(studentDTO);
    }


    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PutMapping
    public ResponseEntity<List<StudentDTO>> updateStudent(@RequestBody List<StudentDTO> studentDTOList){
        return new ResponseEntity<>(studentFacade.updateStudent(studentDTOList),HttpStatus.OK);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("")
    public ResponseEntity<Set<StudentDTO>> getStudents(
            @RequestParam Integer page,
            @RequestParam Integer size,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) String direction) {

        PageValidator.validate(page, size);
        PageDTO<StudentDTO> result = studentFacade.getStudents(page - 1, size, sortBy, direction);
        ResponseEntity<Set<StudentDTO>> responseEntity;

        if (result.hasNext()) {
            responseEntity = new ResponseEntity<>(result.getElements(), HttpStatus.PARTIAL_CONTENT);
        } else {
            responseEntity = new ResponseEntity<>(result.getElements(), HttpStatus.OK);
        }
        return responseEntity;
    }
}
