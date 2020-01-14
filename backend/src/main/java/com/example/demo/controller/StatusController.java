package com.example.demo.controller;

import java.util.List;

import com.example.demo.repository.StatusRepository;
import com.example.demo.entity.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
@CrossOrigin(origins = "http://localhost:8080")
public class StatusController{

    @Autowired
    private StatusRepository statusRepository;

    @GetMapping("/status")
    public List<Status> getStatus(){
        return statusRepository.findAll();
    }
}