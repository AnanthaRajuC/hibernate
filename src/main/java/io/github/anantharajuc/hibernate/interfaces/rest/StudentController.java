package io.github.anantharajuc.hibernate.interfaces.rest;

import io.github.anantharajuc.hibernate.domain.model.project.dto.PageDTO;
import io.github.anantharajuc.hibernate.domain.model.project.dto.StudentDTO;
import io.github.anantharajuc.hibernate.domain.model.project.search.SearchRequest;
import io.github.anantharajuc.hibernate.interfaces.facade.StudentFacade;
import io.github.anantharajuc.hibernate.utils.PageValidator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Log4j2
@RestController
@RequestMapping("/api/v1/students")
@Tag(name = "Student", description = "Student resources that provides access to available student data")
public class StudentController {

    private static final java.util.logging.Logger logSuccess = java.util.logging.Logger.getLogger(StudentController.class.getName());

    @Autowired
    private StudentFacade studentFacade;

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("studentsIds")
    @Operation(summary = "Returns Students for queried Student IDs", description = "Returns Students for queried Student IDs")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Not Found")})
    public List<StudentDTO> getStudentsByIds(@RequestParam("studentIds") List<Long> studentIds){
        return studentFacade.getStudentsByIds(studentIds);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/{studentId}")
    @Operation(summary = "Get student by id", description = "Provides available student by student id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = StudentDTO.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found")})
    public StudentDTO getStudentById(@PathVariable("studentId") Long studentId) {
        logSuccess.info("Student controller");
        return studentFacade.getStudentById(studentId);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Create student", description = "Creates a new student")
    public Long createStudent(@RequestBody StudentDTO studentDTO) {
        return studentFacade.createStudent(studentDTO);
    }


    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PutMapping
    @Operation(summary = "Update student", description = "Updates an existing student")
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

    @DeleteMapping("/{studentId}")
    @Operation(summary = "Delete student by Student Id", description = "Deletes an existing student.")
    public ResponseEntity<Void> deleteStudentById(@PathVariable("studentId") Long studentId,
                                                  @NotNull @Valid @RequestParam(value = "reason", required = true) String reason){
        studentFacade.deleteStudentById(studentId,reason);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/Search")
    public ResponseEntity<List<StudentDTO>> search(@RequestParam String keyword, @RequestBody(required = false) SearchRequest searchRequest){
        return new ResponseEntity<>(studentFacade.search(keyword,searchRequest),HttpStatus.OK);
    }
}
