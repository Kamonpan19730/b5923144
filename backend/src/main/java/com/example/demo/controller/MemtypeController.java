package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.Optional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entity.Memtype;
import com.example.demo.repository.MemtypeRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class MemtypeController {

    @Autowired
    private final MemtypeRepository memtypeRepository;

    public MemtypeController(MemtypeRepository memtypeRepository) {
        this.memtypeRepository = memtypeRepository;
    }

    @GetMapping("/memtype")
    public Collection<Memtype> categorie() {
        return memtypeRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/memtype/{memtypeid}")
    public Optional<Memtype> Memtype(@PathVariable Long id) {
        Optional<Memtype> memtype = memtypeRepository.findById(id);
        return memtype;
    }
}

