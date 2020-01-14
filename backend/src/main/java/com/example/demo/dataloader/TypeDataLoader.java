package com.example.demo.dataloader;

import java.util.stream.Stream;

import com.example.demo.entity.Type;
import com.example.demo.repository.TypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TypeDataLoader implements ApplicationRunner {

    @Autowired private TypeRepository typeRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Stream.of("วีดีโอเพื่อการศึกษา","วีดีโอเพื่อความบันเทิง" ).forEach(type -> {
            Type types = new Type();
            types.setType(type);
            typeRepository.save(types);
        });
    }

    
}