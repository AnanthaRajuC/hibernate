package io.github.anantharajuc.hibernate.application;

import io.github.anantharajuc.hibernate.domain.model.project.Student;

public interface StudentService {
    Student getStudentById(Long StudentId);
}
