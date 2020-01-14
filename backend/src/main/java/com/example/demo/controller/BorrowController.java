package com.example.demo.controller;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;

import com.example.demo.repository.BorrowRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.BookTypeRepository;
import com.example.demo.repository.DocumentRepository;
import com.example.demo.repository.MemtypeRepository;

import com.example.demo.entity.Borrow;
import com.example.demo.entity.Member;
import com.example.demo.entity.BookType;
import com.example.demo.entity.Document;
import com.example.demo.entity.Memtype;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class BorrowController {

    @Autowired
    private final BorrowRepository borrowRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BookTypeRepository booktypeRepository;

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private MemtypeRepository memtypeRepository;

    

    public BorrowController(final BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;
    }

    @GetMapping("/borrow")
    public Collection<Borrow> personnels() {
        return borrowRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/borrow/{numbers}/{member_id}/{bookType_id}/{document_id}/{memType_id}") //can't save bcz on script on vue page is addmember
    public Borrow newBorrow(Borrow newBorrow,
                            @PathVariable  long numbers, 
                            @PathVariable  long member_id,
                            @PathVariable  long bookType_id,
                            @PathVariable  long document_id,
                            @PathVariable  long memType_id
                            ) {
            Member member = memberRepository.findById(member_id);
            BookType booktype = booktypeRepository.findById(bookType_id);                 
            Document document = documentRepository.findById(document_id);
            Memtype memtype = memtypeRepository.findById(memType_id);                     
    
            newBorrow.setMember(member);
            newBorrow.setBookType(booktype);
            newBorrow.setDocument(document);
			newBorrow.setNumbers(numbers);
            newBorrow.setMemtype(memtype);
            newBorrow.setBorrowDate(new Date());
    
        return borrowRepository.save(newBorrow);

}
}