package com.example.demo.dataloader;

import com.example.demo.entity.Status;
import com.example.demo.repository.StatusRepository;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StatusDataLoader implements ApplicationRunner {

    @Autowired private StatusRepository statusRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Stream.of("โสด","แต่งงานแล้ว","อย่าร้าง").forEach(snapshot -> {
            Status status = new Status();
            status.setStatus(snapshot);
            statusRepository.save(status);
        });
       
    }

    
}