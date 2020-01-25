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

public class CategoryTests{
    private Validator validator;

    @Autowired
    private CategoryRepository categoryRepository;

    @BeforeEach
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void b5900428_testCategoryMustBeOK(){

        Category category = new Category();
        category.setCategory("ภาพยนตร์ต่างประเทศ");
        category = categoryRepository.saveAndFlush(category);

        Optional<Category> found = categoryRepository.findById(category.getCategoryid());

        assertEquals("ภาพยนตร์ต่างประเทศ", found.get().getCategory());
    }

    @Test
    void b5900428_testCategoryMustNotBeNull() {

        Category category = new Category();
        category.setCategory(null);

        Set<ConstraintViolation<Category>> result = validator.validate(category);

        assertEquals(1, result.size());

        ConstraintViolation<Category> violation = result.iterator().next();
        assertEquals("Category Must Not Be Null", violation.getMessage());
        assertEquals("category", violation.getPropertyPath().toString());
    }
}