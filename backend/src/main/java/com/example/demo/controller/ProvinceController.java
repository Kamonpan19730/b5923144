package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.Optional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entity.Province;
import com.example.demo.repository.ProvinceRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ProvinceController {

    @Autowired
    private final ProvinceRepository provinceRepository;

    public ProvinceController(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }

    @GetMapping("/province")
    public Collection<Province> categorie() {
        return provinceRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/province/{provinceid}")
    public Optional<Province> Province(@PathVariable Long id) {
        Optional<Province> province = provinceRepository.findById(id);
        return province;
    }
}

