package io.github.anantharajuc.hibernate.application;

import io.github.anantharajuc.hibernate.domain.model.project._mapped_superclass.Student;
import io.github.anantharajuc.hibernate.domain.model.project.dto.StudentDTO;
import io.github.anantharajuc.hibernate.domain.model.project.search.SearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface StudentService {
    Student getStudentById(Long StudentId);

    Student createStudent(Student student);

    Page<Student> getStudents(Integer page, Integer size, Sort sort);

    List<Student> getStudentsByIds(List<Long> studentIds);

    Student updateStudent(Student fromDTO);

    void deleteStudentById(Long studentId, String reason);

    List<Student> search(String keyword, SearchRequest searchRequest);
}
