package com.example.demo.controller;

import java.util.List;

import com.example.demo.repository.StatusRepo;
import com.example.demo.entity.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("status")
public class StatusController{

    @Autowired
    private StatusRepo statusRepo;


    @GetMapping("/status")
    public List<Status> getStatus(){
        return statusRepo.findAll();
    }
}