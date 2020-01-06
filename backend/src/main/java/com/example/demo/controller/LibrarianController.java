package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.Optional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entity.Librarian;
import com.example.demo.repository.LibrarianRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class LibrarianController {

    @Autowired
    private final LibrarianRepository librarianRepository;

    public LibrarianController(LibrarianRepository librarianRepository) {
        this.librarianRepository = librarianRepository;
    }

    @GetMapping("/librarian")
    public Collection<Librarian> librarian() {
        return librarianRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/librarian/{librarianid}")
    public Optional<Librarian> Librarian(@PathVariable Long id) {
        Optional<Librarian> librarian = librarianRepository.findById(id);
        return librarian;
    }
}