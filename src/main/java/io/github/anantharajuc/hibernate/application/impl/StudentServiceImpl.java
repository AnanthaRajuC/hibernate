package io.github.anantharajuc.hibernate.application.impl;

import io.github.anantharajuc.hibernate.application.StudentService;
import io.github.anantharajuc.hibernate.domain.model.project.Student;
import io.github.anantharajuc.hibernate.domain.model.project.repo.StudentRepository;
import io.github.anantharajuc.hibernate.exceptions.ResourceNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
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
        if(student.equals(null) || !StringUtils.hasText(student.getEmail())){
            logError.info("Invalid Input");
            throw new RuntimeException("Invalid Input");
        }
        if(studentRepository.count(Example.of(Student.builder().email(student.getEmail()).build()))==1L){
            logError.info("Student with email %s already present"+student.getEmail());
            throw new RuntimeException(String.format("Student with email %s already present", student.getEmail()));
        }else {
            return studentRepository.save(student);
        }
    }
}
