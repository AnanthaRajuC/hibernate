package io.github.anantharajuc.hibernate.interfaces.rest;

import io.github.anantharajuc.hibernate.application.StudentService;
import io.github.anantharajuc.hibernate.domain.model.project._mapped_superclass.Student;
import io.github.anantharajuc.hibernate.domain.model.project.dto.StudentDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Log4j2
@RestController
@RequestMapping("/api/v1/subjects")
@Tag(name = "Subject", description = "Subject resources that provides access to available student's subject data")
public class SubjectsController {

    @Autowired
    private StudentService studentService;

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/{studentId}")
    @Operation(summary = "Get student by id", description = "Provides available student by student id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found")})
    public Set<String> getStudentSubjectsByStudentId(@PathVariable("studentId") Long studentId) {
        Student student = studentService.getStudentById(studentId);
        return student.getCourse().getSubjects();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("/{studentId}")
    @Operation(summary = "Add subjects to Student", description = "Add subjects to Student")
    public void addSubjectsToStudent(@PathVariable("studentId") Long studentId, @RequestParam("subjects") List<String> subjectsList) {
        Student student = studentService.getStudentById(studentId);
        student.addSubjects(subjectsList);
        studentService.updateStudent(student);
    }
}
