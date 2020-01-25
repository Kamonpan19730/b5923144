package com.example.demo.controller; //กำลังบอกว่า package นี้ เป็นของ Controller

import com.example.demo.entity.*; //import entity ทุกอันมาไว้ในนี้
import com.example.demo.entity.BookCategory;
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
class BookCategoryController{                         
    @Autowired                                          
    private BookCategoryRepository bookcategoryRepository;     

    public BookCategoryController(BookCategoryRepository bookcategoryRepository) {
        this.bookcategoryRepository = bookcategoryRepository;
    }

    @GetMapping("/bookcategory")                           
    public Collection<BookCategory> BookCategorys(){                  
        return bookcategoryRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/bookcategory/{id}")
    public Optional<BookCategory> BookCategorys(@PathVariable Long id) {
        Optional<BookCategory> bookcategory = bookcategoryRepository.findById(id);
        return bookcategory;
    }
}