package io.github.anantharajuc.hibernate.interfaces.rest;

import io.github.anantharajuc.hibernate.domain.model.project.dto.StudentDTO;
import io.github.anantharajuc.hibernate.interfaces.facade.StudentFacade;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
}
