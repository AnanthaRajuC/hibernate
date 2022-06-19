package io.github.anantharajuc.hibernate.application.impl;

import io.github.anantharajuc.hibernate.application.StudentService;
import io.github.anantharajuc.hibernate.domain.model.project._mapped_superclass.Student;
import io.github.anantharajuc.hibernate.domain.model.project.common.Contact;
import io.github.anantharajuc.hibernate.domain.model.project.repo.StudentRepository;
import io.github.anantharajuc.hibernate.exceptions.ResourceNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Log4j2
@Service
public class StudentServiceImpl implements StudentService {

    private static final java.util.logging.Logger logError = java.util.logging.Logger.getLogger("error-logs");

    private static final String MESSAGE_STUDENT_NOT_FOUND_FOR_ID = "Student with id %s not found";

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    @Override
    public Student getStudentById(Long StudentId) {
        log.info("count: "+studentRepository.count());
        log.info("existsById: "+studentRepository.existsById(StudentId));
        final Optional<Student> student = studentRepository.findById(StudentId);
        if (student.isPresent()) {
            return student.get();
        }
        else {
            logError.info("Resource not found");
            throw new ResourceNotFoundException("Student", "id", StudentId);
        }
    }

    @Transactional
    @Override
    public Student createStudent(Student student) {
        if(student.equals(null) || !StringUtils.hasText(student.getContact().getEmail())){
            logError.info("Invalid Input");
            throw new RuntimeException("Invalid Input");
        }
        /*if(studentRepository.count(Example.of(Student.builder().email(student.getContact().getEmail()).build()))==1L){*/
        if(studentRepository.count(Example.of(Student.builder()
                .contact(Contact.builder().email(student.getContact().getEmail()).build())
                .build()))==1L){
            logError.info("Student with email %s already present"+student.getContact().getEmail());
            throw new RuntimeException(String.format("Student with email %s already present", student.getContact().getEmail()));
        }else {
            return studentRepository.save(student);
        }
    }

    @Transactional
    @Override
    public Page<Student> getStudents(Integer page, Integer size, Sort sort) {
        log.info("getStudents() called  with: page = {}, size = {}, sort = {}", page, size, sort);
        Example<Student> studentExample = Example.of(Student.builder().build());
        return studentRepository.findAll(studentExample, PageRequest.of(page, size, sort));
    }

    @Override
    public List<Student> getStudentsByIds(List<Long> studentIds) {
        return studentRepository.findAllById(studentIds);
    }

    @Override
    public Student updateStudent(Student studentToBeUpdated) {
        if (!studentRepository.existsById(Objects.requireNonNull(studentToBeUpdated.getId(), "Student Id cannot be null"))) {
            throw new ResourceNotFoundException("Student","id",studentToBeUpdated.getId());
        }
        return studentRepository.save(studentToBeUpdated);
    }

    @Override
    public void deleteStudentById(Long studentId, String reason) {
        Student student = getStudentById(studentId);
        student.deactivate(reason);
        studentRepository.save(student);
    }
}
