package com.example.demo.controller;                    //กำลังบอกว่า package นี้ เป็นของ Controller
import com.example.demo.entity.*;                         //import entity ทุกอันมาไว้ในนี้
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
class BookTypeController{                         
    @Autowired                                          
    private BookTypeRepository booktypeRepository;     

    public BookTypeController(BookTypeRepository booktypeRepository) {
        this.booktypeRepository = booktypeRepository;
    }

    @GetMapping("/booktype")                           
    public Collection<BookType> BookTypes(){                  
        return booktypeRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/booktype/{id}")
    public Optional<BookType> BookTypes(@PathVariable Long id) {
        Optional<BookType> booktype = booktypeRepository.findById(id);
        return booktype;
    }
}