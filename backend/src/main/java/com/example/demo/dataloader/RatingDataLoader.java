package com.example.demo.dataloader;

import java.util.stream.Stream;

import com.example.demo.entity.Rating;
import com.example.demo.repository.RatingRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class RatingDataLoader implements ApplicationRunner {

    @Autowired
    private RatingRepo ratingRepo;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Stream.of("น้อยที่สุด", "น้อย", "ปานกลาง", "มาก", "มากที่สุด").forEach(rate -> {
            Rating rating = new Rating();
            rating.setRating(rate);
            ratingRepo.save(rating);
        });
      //  ratingRepo.findAll().forEach(System.out::println);
    }


}