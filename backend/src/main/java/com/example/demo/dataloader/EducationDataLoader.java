package com.example.demo.dataloader;

import java.util.stream.Stream;

import com.example.demo.entity.EducationLevel;
import com.example.demo.repository.EducationLevelRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class EducationDataLoader implements ApplicationRunner {

    @Autowired private EducationLevelRepo educationLevelRepo;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Stream.of("มัธยมต้น(ม.3)","มัธยมปลาย(ม.6)","ปริญญาตรี","ปริญญาโท","ปริญญาเอก","อื่นๆ","ไม่ต้องการระบุ" ).forEach(edulevel -> {
            EducationLevel educationLevel = new EducationLevel();
            educationLevel.setEdlevel(edulevel);
            educationLevelRepo.save(educationLevel);
        });
       // memberRepo.findAll().forEach(System.out::println);
    }

    
}