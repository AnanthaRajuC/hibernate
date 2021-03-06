package io.github.anantharajuc.hibernate.domain.model.project.repo;

import io.github.anantharajuc.hibernate.domain.model.project._mapped_superclass.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}