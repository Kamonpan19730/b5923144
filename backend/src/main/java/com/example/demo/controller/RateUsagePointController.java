package com.example.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.example.demo.entity.EducationLevel;
import com.example.demo.entity.RateUsagePoint;
import com.example.demo.entity.Status;
import com.example.demo.entity.Rating;
import com.example.demo.repository.EducationLevelRepo;
import com.example.demo.repository.RateUsagePointRepo;
import com.example.demo.repository.RatingRepo;
import com.example.demo.repository.StatusRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Rates")
@CrossOrigin(origins = "http://localhost/8080")
public class RateUsagePointController{

    @Autowired
    private RateUsagePointRepo RateRepo;

    @Autowired
    private EducationLevelRepo eduRepo;

    @Autowired
    private RatingRepo  ratingRepo;

    @Autowired
    private StatusRepo statusRepo;

    @GetMapping("/RateUsage")
    public List<RateUsagePoint> getRateUsagePoint(){
        return RateRepo.findAll();
    }

    @PostMapping("/add")
    public RateUsagePoint addRateUsagePoint(@RequestBody    Map<String, String> body){
        RateUsagePoint newRateUP = new RateUsagePoint();
        EducationLevel edlevel = eduRepo.findById(Long.valueOf(body.get("edulevel").toString())).get();
        Status status = statusRepo.findById(Long.valueOf(body.get("status").toString())).get();
        Rating rating = ratingRepo.findById(Long.valueOf(body.get("rating").toString())).get();

        newRateUP.setEdlevel(edlevel);
        newRateUP.setStatus(status);
        newRateUP.setDate(new Date());
        newRateUP.setEmail(body.get("email").toString());
        newRateUP.setSuggestion(body.get("suggestion").toString());
        newRateUP.setRating(rating);

        return RateRepo.save(newRateUP);
    }

}