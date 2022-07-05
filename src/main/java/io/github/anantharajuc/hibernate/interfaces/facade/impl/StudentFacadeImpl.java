package io.github.anantharajuc.hibernate.interfaces.facade.impl;

import io.github.anantharajuc.hibernate.application.StudentService;
import io.github.anantharajuc.hibernate.domain.model.project._mapped_superclass.Student;
import io.github.anantharajuc.hibernate.domain.model.project.dto.PageDTO;
import io.github.anantharajuc.hibernate.domain.model.project.dto.StudentDTO;
import io.github.anantharajuc.hibernate.domain.model.project.search.SearchRequest;
import io.github.anantharajuc.hibernate.interfaces.facade.StudentFacade;
import io.github.anantharajuc.hibernate.interfaces.facade.assembler.StudentDTOAssembler;
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
public class StudentFacadeImpl implements StudentFacade {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentDTOAssembler studentDTOAssembler;

    @Override
    public StudentDTO getStudentById(Long studentId) {
        final Student student = studentService.getStudentById(studentId);
        return studentDTOAssembler.toDTO(student);
    }

    @Override
    public Long createStudent(StudentDTO studentDTO) {
        Student student = studentDTOAssembler.fromDTO(studentDTO);
        student = studentService.createStudent(student);
        return student.getId();
    }

    @Override
    public PageDTO<StudentDTO> getStudents(Integer page, Integer size, String sortBy, String direction) {
        final Page<Student> studentPage = studentService.getStudents(page, size, JPAUtility.convertToSort(sortBy, direction));
        final Set<StudentDTO> studentDTOList = studentPage.get().map(studentDTOAssembler::toDTO).collect(Collectors.toSet());
        return new PageDTO<>(studentDTOList, studentPage.hasNext());
    }

    @Override
    public List<StudentDTO> updateStudent(List<StudentDTO> studentDTOs) {
        List<Student> updatedStudentList = new ArrayList<>();
        studentDTOs.forEach(studentDTO -> updatedStudentList.add(studentService.updateStudent(studentDTOAssembler.fromDTO(studentDTO))));
        return updatedStudentList.stream().map(studentDTOAssembler::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> getStudentsByIds(List<Long> studentIds) {
        List<Student> studentsList = studentService.getStudentsByIds(studentIds);
        return studentsList.stream().map(student -> studentDTOAssembler.toDTO(student)).collect(Collectors.toList());
    }

    @Override
    public void deleteStudentById(Long studentId, String reason) {
        studentService.deleteStudentById(studentId,reason);
    }

    @Override
    public List<StudentDTO> search(String keyword, SearchRequest searchRequest) {
        List<Student> studentsList = studentService.search(keyword,searchRequest);
        return studentsList.stream().map(student -> studentDTOAssembler.toDTO(student)).collect(Collectors.toList());
    }
}
