package com.example.demo.controller; //กำลังบอกว่า package นี้ เป็นของ Controller

import com.example.demo.entity.*; //import entity ทุกอันมาไว้ในนี้
import com.example.demo.entity.Number;
import com.example.demo.repository.*;                     //import repo ทุกอันมาไว้ในนี้
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;
@RestController                                 
@CrossOrigin(origins = "http://localhost:8080") 
class NumberController{                         
    @Autowired                                          
    private NumberRepository numberRepository;     

    public NumberController(NumberRepository numberRepository) {
        this.numberRepository = numberRepository;
    }

    @GetMapping("/number")                           
    public Collection<Number> Numbers(){                  
        return numberRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/number/{id}")
    public Optional<Number> Numbers(@PathVariable Long id) {
        Optional<Number> number = numberRepository.findById(id);
        return number;
    }
}