package com.example.demo.dataloader;

import java.util.stream.Stream;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CategoryDataLoader implements ApplicationRunner {

    @Autowired private CategoryRepository categoryRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Stream.of("ภาพยนตร์ต่างประเทศ","ภาพยนตร์ไทย","วีดีโอประกอบรายวิชาภาษาต่างประเทศ","วีดีโอประกอบรายวิชาภาษาไทย",
                    "วีดีโอวรรณคดี","วีดีโอรายวิชาวิทยาศาสตร์และดาราศาสตร์","วีดีโอประวัติศาสตร์ และสังคมศาสตร์","วีดีโอราบวิชาคณิตศาสตร์" ).forEach(category -> {
            Category categorys = new Category();
            categorys.setCategory(category);
            categoryRepository.save(categorys);
        });
    }

    
}