package com.example.demo.controller; //กำลังบอกว่า package นี้ เป็นของ Controller

import com.example.demo.entity.*; //import entity ทุกอันมาไว้ในนี้
import com.example.demo.repository.*; //import repo ทุกอันมาไว้ในนี้
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PathVariable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.stream.Collectors;

@RestController                                 
@CrossOrigin(origins = "http://localhost:8080") 
class BookStatusController{                         
    @Autowired                                          
    private BookStatusRepository bookStatusRepository;     

    @GetMapping("/bookstatus")                           
    public Collection<BookStatus> getAllBookStatus(){                  
        return bookStatusRepository.findAll().stream().collect(Collectors.toList());
    }
}