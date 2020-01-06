package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.Optional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entity.Prefix;
import com.example.demo.repository.PrefixRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class PrefixController {

    @Autowired
    private final PrefixRepository prefixRepository;

    public PrefixController(PrefixRepository prefixRepository) {
        this.prefixRepository = prefixRepository;
    }

    @GetMapping("/prefix")
    public Collection<Prefix> categorie() {
        return prefixRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/prefix/{prefixid}")
    public Optional<Prefix> Prefix(@PathVariable Long id) {
        Optional<Prefix> prefix = prefixRepository.findById(id);
        return prefix;
    }
}