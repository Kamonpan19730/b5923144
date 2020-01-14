package com.example.demo.dataloader;

import java.util.stream.Stream;

import com.example.demo.entity.Librarian;
import com.example.demo.repository.LibrarianRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class LibrarianDataLoader implements ApplicationRunner {

    @Autowired private LibrarianRepository librarianRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Stream.of("นางสาวใจดี ดีใจ","นางสาวรัก สะอาด" ).forEach(librarianName -> {
            Librarian librarian = new Librarian();
            librarian.setLibrarianName(librarianName);
            librarianRepository.save(librarian);
        });
    }

    
}