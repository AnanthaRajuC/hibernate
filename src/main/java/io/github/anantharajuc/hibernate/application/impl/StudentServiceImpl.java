package io.github.anantharajuc.hibernate.application.impl;

import io.github.anantharajuc.hibernate.application.StudentService;
import io.github.anantharajuc.hibernate.domain.model.project.Student;
import io.github.anantharajuc.hibernate.domain.model.project.repo.StudentRepository;
import io.github.anantharajuc.hibernate.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

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
            throw new ResourceNotFoundException("Student", "id", StudentId);
        }
    }
}
