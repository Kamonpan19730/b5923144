package com.example.demo.controller;

import java.util.List;
import com.example.demo.entity.Rating;
import com.example.demo.repository.RatingRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("ratings")
@CrossOrigin(origins = "http://localhost:8080")
public class RatingController {

    @Autowired
    private RatingRepo ratingRepo;

    @GetMapping("/rating")
    public List<Rating> getRating() {
        return ratingRepo.findAll();
    }

}