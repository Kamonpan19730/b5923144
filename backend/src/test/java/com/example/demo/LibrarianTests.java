package com.example.demo;

import com.example.demo.entity.*;
import com.example.demo.repository.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.ConstraintViolation;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest

public class LibrarianTests{
    private Validator validator;

    @Autowired
    private LibrarianRepository librarianRepository;

    @BeforeEach
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void b5900428_testLibrarianMustBeOK(){

        Librarian librarian = new Librarian();
        librarian.setLibrarianName("นางสาวใจดี ดีใจ");
        librarian = librarianRepository.saveAndFlush(librarian);

        Optional<Librarian> found = librarianRepository.findById(librarian.getLibrarianid());

        assertEquals("นางสาวใจดี ดีใจ", found.get().getLibrarianName());
    }

    @Test
    void b5900428_testLibrarianNameMustNotBeNull() {

        Librarian librarian = new Librarian();
        librarian.setLibrarianName(null);

        Set<ConstraintViolation<Librarian>> result = validator.validate(librarian);

        assertEquals(1, result.size());

        ConstraintViolation<Librarian> violation = result.iterator().next();
        assertEquals("LibrarianName Must Not Be Null", violation.getMessage());
        assertEquals("librarianName", violation.getPropertyPath().toString());
    }
}