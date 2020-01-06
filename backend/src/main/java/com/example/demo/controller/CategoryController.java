package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.Optional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class CategoryController {

    @Autowired
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/category")
    public Collection<Category> categorie() {
        return categoryRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/category/{categoryid}")
    public Optional<Category> Category(@PathVariable Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category;
    }
}