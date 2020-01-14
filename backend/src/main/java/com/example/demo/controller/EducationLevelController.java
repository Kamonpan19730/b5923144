package com.example.demo.controller;

import com.example.demo.repository.EducationLevelRepo;

import java.util.List;

import com.example.demo.entity.EducationLevel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eduLevels")
@CrossOrigin(origins = "http://localhost:8080")
public class EducationLevelController{

    @Autowired
    private EducationLevelRepo EduRepo;

    @GetMapping("/eduLevel")
    public List<EducationLevel> getEducationLevel(){
        return  EduRepo.findAll();
    }

}