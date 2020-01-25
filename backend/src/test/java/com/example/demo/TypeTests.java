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

public class TypeTests{
    private Validator validator;

    @Autowired
    private TypeRepository typeRepository;

    @BeforeEach
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void b5900428_testTypeMustBeOK(){

        Type type = new Type();
        type.setType("วีดีโอเพื่อการศึกษา");
        type = typeRepository.saveAndFlush(type);

        Optional<Type> found = typeRepository.findById(type.getTypeid());

        assertEquals("วีดีโอเพื่อการศึกษา", found.get().getType());
    }

    @Test
    void b5900428_testTypeMustNotBeNull() {

        Type type = new Type();
        type.setType(null);

        Set<ConstraintViolation<Type>> result = validator.validate(type);

        assertEquals(1, result.size());

        ConstraintViolation<Type> violation = result.iterator().next();
        assertEquals("Type Must Not Be Null", violation.getMessage());
        assertEquals("type", violation.getPropertyPath().toString());
    }
}