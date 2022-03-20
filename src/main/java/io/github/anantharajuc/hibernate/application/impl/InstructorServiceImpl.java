package io.github.anantharajuc.hibernate.application.impl;

import io.github.anantharajuc.hibernate.application.InstructorService;
import io.github.anantharajuc.hibernate.domain.model.project._mapped_superclass.Instructor;
import io.github.anantharajuc.hibernate.domain.model.project.common.Contact;
import io.github.anantharajuc.hibernate.domain.model.project.repo.InstructorRepository;
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
import java.util.Objects;
import java.util.Optional;

@Log4j2
@Service
public class InstructorServiceImpl implements InstructorService {

    private static final java.util.logging.Logger logError = java.util.logging.Logger.getLogger("error-logs");

    private static final String MESSAGE_INSTRUCTOR_NOT_FOUND_FOR_ID = "Instructor with id %s not found";

    @Autowired
    private InstructorRepository instructorRepository;

    @Transactional
    @Override
    public Instructor getInstructorById(Long InstructorId) {
        final Optional<Instructor> instructor = instructorRepository.findById(InstructorId);
        if (instructor.isPresent()) {
            return instructor.get();
        }
        else {
            logError.info("Resource not found");
            throw new ResourceNotFoundException("Instructor", "id", InstructorId);
        }
    }

    @Transactional
    @Override
    public Instructor createInstructor(Instructor instructor) {
        if(instructor.equals(null) || !StringUtils.hasText(instructor.getContact().getEmail())){
            logError.info("Invalid Input");
            throw new RuntimeException("Invalid Input");
        }
        /*if(studentRepository.count(Example.of(Student.builder().email(student.getContact().getEmail()).build()))==1L){*/
        if(instructorRepository.count(Example.of(Instructor.builder()
                .contact(Contact.builder().email(instructor.getContact().getEmail()).build())
                .build()))==1L){
            logError.info("Instructor with email %s already present"+instructor.getContact().getEmail());
            throw new RuntimeException(String.format("Instructor with email %s already present", instructor.getContact().getEmail()));
        }else {
            return instructorRepository.save(instructor);
        }
    }

    @Transactional
    @Override
    public Page<Instructor> getInstructors(Integer page, Integer size, Sort sort) {
        log.info("getStudents() called  with: page = {}, size = {}, sort = {}", page, size, sort);
        Example<Instructor> instructorExample = Example.of(Instructor.builder().build());
        return instructorRepository.findAll(instructorExample,PageRequest.of(page, size, sort));
    }

    @Override
    public Instructor updateInstructor(Instructor instructorToBeUpdated) {
        if (!instructorRepository.existsById(Objects.requireNonNull(instructorToBeUpdated.getId(), "Instructor Id cannot be null"))) {
            throw new ResourceNotFoundException("Instructor","id",instructorToBeUpdated.getId());
        }
        return instructorRepository.save(instructorToBeUpdated);
    }
}
