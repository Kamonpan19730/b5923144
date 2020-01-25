package com.example.demo;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.ConstraintViolation;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
public class VideoTests{
    private Validator validator;

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private LibrarianRepository librarianRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @BeforeEach
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void b5900428_testVideoMustBeOK(){
        Video video = new Video();

        Type type = new Type();
        type.setType("วีดีโอเพื่อการศึกษา");
        type = typeRepository.saveAndFlush(type);

        Librarian librarian = new Librarian();
        librarian.setLibrarianName("นางสาวใจดี ดีใจ");
        librarian = librarianRepository.saveAndFlush(librarian);

        Category category = new Category();
        category.setCategory("ภาพยนตร์ต่างประเทศ");
        category = categoryRepository.saveAndFlush(category);

        video.setVideoName("videoName");
        video.setVideoCode("12345");
        video.setType(type);
        video.setLibrarian(librarian);
        video.setCategory(category);

        video = videoRepository.saveAndFlush(video);

        Optional<Video> found = videoRepository.findById(video.getVideoid());

        assertEquals("videoName", found.get().getVideoName());
        assertEquals("12345", found.get().getVideoCode());
        assertEquals(type, found.get().getType());
        assertEquals(librarian, found.get().getLibrarian());
        assertEquals(category, found.get().getCategory());
    }

    @Test
    void b5900428_testVideoNameMustNotBeNull() {
        Video video = new Video();

        Type type = new Type();
        type.setType("วีดีโอเพื่อการศึกษา");
        type = typeRepository.saveAndFlush(type);

        Librarian librarian = new Librarian();
        librarian.setLibrarianName("นางสาวใจดี ดีใจ");
        librarian = librarianRepository.saveAndFlush(librarian);

        Category category = new Category();
        category.setCategory("ภาพยนตร์ต่างประเทศ");
        category = categoryRepository.saveAndFlush(category);

        video.setVideoName(null);
        video.setVideoCode("12345");
        video.setType(type);
        video.setLibrarian(librarian);
        video.setCategory(category);

        Set<ConstraintViolation<Video>> result = validator.validate(video);

        assertEquals(1, result.size());

        ConstraintViolation<Video> violation = result.iterator().next();
        assertEquals("videoName must not be null", violation.getMessage());
        assertEquals("videoName", violation.getPropertyPath().toString());
    }

    @Test
    void b5900428_testVideoCodeMustNotBeNull() {
        Video video = new Video();

        Type type = new Type();
        type.setType("วีดีโอเพื่อการศึกษา");
        type = typeRepository.saveAndFlush(type);

        Librarian librarian = new Librarian();
        librarian.setLibrarianName("นางสาวใจดี ดีใจ");
        librarian = librarianRepository.saveAndFlush(librarian);

        Category category = new Category();
        category.setCategory("ภาพยนตร์ต่างประเทศ");
        category = categoryRepository.saveAndFlush(category);

        video.setVideoName("videoName");
        video.setVideoCode(null);
        video.setType(type);
        video.setLibrarian(librarian);
        video.setCategory(category);

        Set<ConstraintViolation<Video>> result = validator.validate(video);

        assertEquals(1, result.size());

        ConstraintViolation<Video> violation = result.iterator().next();
        assertEquals("VideoCode Must Not Be Null", violation.getMessage());
        assertEquals("videoCode", violation.getPropertyPath().toString());
    }

    @Test
    void b5900428_testVideoNameMustNotMoreThan20Characters() {
        Video video = new Video();

        Type type = new Type();
        type.setType("วีดีโอเพื่อการศึกษา");
        type = typeRepository.saveAndFlush(type);

        Librarian librarian = new Librarian();
        librarian.setLibrarianName("นางสาวใจดี ดีใจ");
        librarian = librarianRepository.saveAndFlush(librarian);

        Category category = new Category();
        category.setCategory("ภาพยนตร์ต่างประเทศ");
        category = categoryRepository.saveAndFlush(category);

        video.setVideoName("123456789012345678901");
        video.setVideoCode("12345");
        video.setType(type);
        video.setLibrarian(librarian);
        video.setCategory(category);

        Set<ConstraintViolation<Video>> result = validator.validate(video);

        assertEquals(1, result.size());

        ConstraintViolation<Video> violation = result.iterator().next();
        assertEquals("VideoName Must Be Beetween 2-20 Characters", violation.getMessage());
        assertEquals("videoName", violation.getPropertyPath().toString());
    }

    @Test
    void b5900428_testVideoNameMustBeBeetween2to20Characters() {
        Video video = new Video();

        Type type = new Type();
        type.setType("วีดีโอเพื่อการศึกษา");
        type = typeRepository.saveAndFlush(type);

        Librarian librarian = new Librarian();
        librarian.setLibrarianName("นางสาวใจดี ดีใจ");
        librarian = librarianRepository.saveAndFlush(librarian);

        Category category = new Category();
        category.setCategory("ภาพยนตร์ต่างประเทศ");
        category = categoryRepository.saveAndFlush(category);

        video.setVideoName("1234567890");
        video.setVideoCode("12345");
        video.setType(type);
        video.setLibrarian(librarian);
        video.setCategory(category);

        video = videoRepository.saveAndFlush(video);

        Optional<Video> found = videoRepository.findById(video.getVideoid());

        assertEquals("1234567890", found.get().getVideoName());
        assertEquals("12345", found.get().getVideoCode());
        assertEquals(type, found.get().getType());
        assertEquals(librarian, found.get().getLibrarian());
        assertEquals(category, found.get().getCategory());
    }

    @Test
    void b5900428_testVideoNameMustNotLessThan2Characters() {
        Video video = new Video();

        Type type = new Type();
        type.setType("วีดีโอเพื่อการศึกษา");
        type = typeRepository.saveAndFlush(type);

        Librarian librarian = new Librarian();
        librarian.setLibrarianName("นางสาวใจดี ดีใจ");
        librarian = librarianRepository.saveAndFlush(librarian);

        Category category = new Category();
        category.setCategory("ภาพยนตร์ต่างประเทศ");
        category = categoryRepository.saveAndFlush(category);

        video.setVideoName("1");
        video.setVideoCode("12345");
        video.setType(type);
        video.setLibrarian(librarian);
        video.setCategory(category);

        Set<ConstraintViolation<Video>> result = validator.validate(video);

        assertEquals(1, result.size());

        ConstraintViolation<Video> violation = result.iterator().next();
        assertEquals("VideoName Must Be Beetween 2-20 Characters", violation.getMessage());
        assertEquals("videoName", violation.getPropertyPath().toString());
    }

    @Test
    void b5900428_testVideoNameMustBeUnique() {

        Type type = new Type();
        type.setType("วีดีโอเพื่อการศึกษา");
        type = typeRepository.saveAndFlush(type);

        Librarian librarian = new Librarian();
        librarian.setLibrarianName("นางสาวใจดี ดีใจ");
        librarian = librarianRepository.saveAndFlush(librarian);

        Category category = new Category();
        category.setCategory("ภาพยนตร์ต่างประเทศ");
        category = categoryRepository.saveAndFlush(category);

        Video video = new Video();

        video.setVideoName("videoName");
        video.setVideoCode("12345");
        video.setType(type);
        video.setLibrarian(librarian);
        video.setCategory(category);

        video = videoRepository.saveAndFlush(video);

        assertThrows(DataIntegrityViolationException.class, () -> {
            Type type2 = new Type();
            type2.setType("วีดีโอเพื่อการศึกษา");
            type2 = typeRepository.saveAndFlush(type2);

            Librarian librarian2 = new Librarian();
            librarian2.setLibrarianName("นางสาวใจดี ดีใจ");
            librarian2 = librarianRepository.saveAndFlush(librarian2);

            Category category2 = new Category();
            category2.setCategory("ภาพยนตร์ต่างประเทศ");
            category2 = categoryRepository.saveAndFlush(category2);

            Video video2 = new Video();

            video2.setVideoName("videoName");
            video2.setVideoCode("12345");
            video2.setType(type2);
            video2.setLibrarian(librarian2);
            video2.setCategory(category2);

            video2 = videoRepository.saveAndFlush(video2);
        });       
    }

    @Test
    void b5900428_testVideoCodeMustBeUnique() {

        Type type = new Type();
        type.setType("วีดีโอเพื่อการศึกษา");
        type = typeRepository.saveAndFlush(type);

        Librarian librarian = new Librarian();
        librarian.setLibrarianName("นางสาวใจดี ดีใจ");
        librarian = librarianRepository.saveAndFlush(librarian);

        Category category = new Category();
        category.setCategory("ภาพยนตร์ต่างประเทศ");
        category = categoryRepository.saveAndFlush(category);

        Video video = new Video();

        video.setVideoName("videoName");
        video.setVideoCode("12345");
        video.setType(type);
        video.setLibrarian(librarian);
        video.setCategory(category);

        video = videoRepository.saveAndFlush(video);

        assertThrows(DataIntegrityViolationException.class, () -> {
            Type type2 = new Type();
            type2.setType("วีดีโอเพื่อการศึกษา");
            type2 = typeRepository.saveAndFlush(type2);

            Librarian librarian2 = new Librarian();
            librarian2.setLibrarianName("นางสาวใจดี ดีใจ");
            librarian2 = librarianRepository.saveAndFlush(librarian2);

            Category category2 = new Category();
            category2.setCategory("ภาพยนตร์ต่างประเทศ");
            category2 = categoryRepository.saveAndFlush(category2);

            Video video2 = new Video();

            video2.setVideoName("videoName");
            video2.setVideoCode("12345");
            video2.setType(type2);
            video2.setLibrarian(librarian2);
            video2.setCategory(category2);

            video2 = videoRepository.saveAndFlush(video2);
        });       
    }

    @Test
    void b5900428_testVideoCodeMustNotBe6Digits() {
        Video video = new Video();

        Type type = new Type();
        type.setType("วีดีโอเพื่อการศึกษา");
        type = typeRepository.saveAndFlush(type);

        Librarian librarian = new Librarian();
        librarian.setLibrarianName("นางสาวใจดี ดีใจ");
        librarian = librarianRepository.saveAndFlush(librarian);

        Category category = new Category();
        category.setCategory("ภาพยนตร์ต่างประเทศ");
        category = categoryRepository.saveAndFlush(category);

        video.setVideoName("videoName");
        video.setVideoCode("123456");
        video.setType(type);
        video.setLibrarian(librarian);
        video.setCategory(category);

        Set<ConstraintViolation<Video>> result = validator.validate(video);

        assertEquals(1, result.size());

        ConstraintViolation<Video> violation = result.iterator().next();
        assertEquals("VideoCode Must Have 5 digits", violation.getMessage());
        assertEquals("videoCode", violation.getPropertyPath().toString());
    }

    @Test
    void b5900428_testVideoCodeMustNotBe4Digits() {
        Video video = new Video();

        Type type = new Type();
        type.setType("วีดีโอเพื่อการศึกษา");
        type = typeRepository.saveAndFlush(type);

        Librarian librarian = new Librarian();
        librarian.setLibrarianName("นางสาวใจดี ดีใจ");
        librarian = librarianRepository.saveAndFlush(librarian);

        Category category = new Category();
        category.setCategory("ภาพยนตร์ต่างประเทศ");
        category = categoryRepository.saveAndFlush(category);

        video.setVideoName("videoName");
        video.setVideoCode("1234");
        video.setType(type);
        video.setLibrarian(librarian);
        video.setCategory(category);

        Set<ConstraintViolation<Video>> result = validator.validate(video);

        assertEquals(1, result.size());

        ConstraintViolation<Video> violation = result.iterator().next();
        assertEquals("VideoCode Must Have 5 digits", violation.getMessage());
        assertEquals("videoCode", violation.getPropertyPath().toString());
    }

    @Test
    void b5900428_testVideoCodeMustNotBe3Digits() {
        Video video = new Video();

        Type type = new Type();
        type.setType("วีดีโอเพื่อการศึกษา");
        type = typeRepository.saveAndFlush(type);

        Librarian librarian = new Librarian();
        librarian.setLibrarianName("นางสาวใจดี ดีใจ");
        librarian = librarianRepository.saveAndFlush(librarian);

        Category category = new Category();
        category.setCategory("ภาพยนตร์ต่างประเทศ");
        category = categoryRepository.saveAndFlush(category);

        video.setVideoName("videoName");
        video.setVideoCode("123");
        video.setType(type);
        video.setLibrarian(librarian);
        video.setCategory(category);

        Set<ConstraintViolation<Video>> result = validator.validate(video);

        assertEquals(1, result.size());

        ConstraintViolation<Video> violation = result.iterator().next();
        assertEquals("VideoCode Must Have 5 digits", violation.getMessage());
        assertEquals("videoCode", violation.getPropertyPath().toString());
    }

    @Test
    void b5900428_testVideoCodeMustNotBe2Digits() {
        Video video = new Video();

        Type type = new Type();
        type.setType("วีดีโอเพื่อการศึกษา");
        type = typeRepository.saveAndFlush(type);

        Librarian librarian = new Librarian();
        librarian.setLibrarianName("นางสาวใจดี ดีใจ");
        librarian = librarianRepository.saveAndFlush(librarian);

        Category category = new Category();
        category.setCategory("ภาพยนตร์ต่างประเทศ");
        category = categoryRepository.saveAndFlush(category);

        video.setVideoName("videoName");
        video.setVideoCode("12");
        video.setType(type);
        video.setLibrarian(librarian);
        video.setCategory(category);

        Set<ConstraintViolation<Video>> result = validator.validate(video);

        assertEquals(1, result.size());

        ConstraintViolation<Video> violation = result.iterator().next();
        assertEquals("VideoCode Must Have 5 digits", violation.getMessage());
        assertEquals("videoCode", violation.getPropertyPath().toString());
    }

    @Test
    void b5900428_testVideoCodeMustNotBe1Digits() {
        Video video = new Video();

        Type type = new Type();
        type.setType("วีดีโอเพื่อการศึกษา");
        type = typeRepository.saveAndFlush(type);

        Librarian librarian = new Librarian();
        librarian.setLibrarianName("นางสาวใจดี ดีใจ");
        librarian = librarianRepository.saveAndFlush(librarian);

        Category category = new Category();
        category.setCategory("ภาพยนตร์ต่างประเทศ");
        category = categoryRepository.saveAndFlush(category);

        video.setVideoName("videoName");
        video.setVideoCode("1");
        video.setType(type);
        video.setLibrarian(librarian);
        video.setCategory(category);

        Set<ConstraintViolation<Video>> result = validator.validate(video);

        assertEquals(1, result.size());

        ConstraintViolation<Video> violation = result.iterator().next();
        assertEquals("VideoCode Must Have 5 digits", violation.getMessage());
        assertEquals("videoCode", violation.getPropertyPath().toString());
    }

    @Test
    void b5900428_testVideoCodeMustNotBe5DigitsOK() {
        Video video = new Video();

        Type type = new Type();
        type.setType("วีดีโอเพื่อการศึกษา");
        type = typeRepository.saveAndFlush(type);

        Librarian librarian = new Librarian();
        librarian.setLibrarianName("นางสาวใจดี ดีใจ");
        librarian = librarianRepository.saveAndFlush(librarian);

        Category category = new Category();
        category.setCategory("ภาพยนตร์ต่างประเทศ");
        category = categoryRepository.saveAndFlush(category);

        video.setVideoName("videoName");
        video.setVideoCode("12345");
        video.setType(type);
        video.setLibrarian(librarian);
        video.setCategory(category);

        video = videoRepository.saveAndFlush(video);

        Optional<Video> found = videoRepository.findById(video.getVideoid());

        assertEquals("videoName", found.get().getVideoName());
        assertEquals("12345", found.get().getVideoCode());
        assertEquals(type, found.get().getType());
        assertEquals(librarian, found.get().getLibrarian());
        assertEquals(category, found.get().getCategory());
    }
}
