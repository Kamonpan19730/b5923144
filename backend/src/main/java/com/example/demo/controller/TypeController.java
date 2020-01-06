package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.Optional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entity.Type;
import com.example.demo.repository.TypeRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class TypeController {

    @Autowired
    private final TypeRepository typeRepository;

    public TypeController(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @GetMapping("/type")
    public Collection<Type> symptom() {
        return typeRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/type/{typeid}")
    public Optional<Type> Type(@PathVariable Long id) {
        Optional<Type> type = typeRepository.findById(id);
        return type;
    }
}