package io.github.anantharajuc.hibernate.domain.model.project.repo;

import io.github.anantharajuc.hibernate.domain.model.project.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
