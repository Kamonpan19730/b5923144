package com.example.demo.controller; //กำลังบอกว่า package นี้ เป็นของ Controller
import com.example.demo.entity.*; //import entity ทุกอันมาไว้ในนี้
import com.example.demo.entity.Number;
import com.example.demo.repository.*;                     //import repo ทุกอันมาไว้ในนี้
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;
@RestController                                     //บังคับให้ class นี้เป็น Controller
@CrossOrigin(origins = "http://localhost:8080")     //ทำให้ spingboot , vue ส่งข้อมูหากันได้
class DocumentController{                           //บอกตำแหน่งปัจจุบัน 
    @Autowired                                      //สร้างผู้ช่วย ที่คอยสั่ง Repo ให้ทำงานอัตโนมัติ
    private DocumentRepository documentRepository;  //สร้าง Obj ชื่อ documentRepo.. ชนิด DocumentRepo.. เพื่อใช้งาน Entity Document
    @Autowired                                      //สร้างผู้ช่วย ที่คอยสั่ง Repo ให้ทำงานอัตโนมัติ
    private BookTypeRepository booktypeRepository;    
    @Autowired                                      //สร้างผู้ช่วย ที่คอยสั่ง Repo ให้ทำงานอัตโนมัติ
    private LanguageRepository languageRepository;  
    @Autowired                                      //สร้างผู้ช่วย ที่คอยสั่ง Repo ให้ทำงานอัตโนมัติ
    private NumberRepository numberRepository;      
    
    DocumentController(DocumentRepository documentRepository,BookTypeRepository booktypeRepository,LanguageRepository languageRepository,NumberRepository numberRepository) {
        this.documentRepository = documentRepository;
        this.booktypeRepository = booktypeRepository;
        this.numberRepository = numberRepository;
        this.languageRepository = languageRepository;
    }

    @GetMapping("/document")                                                       // get ข้อมูลตาม พาท ที่กำหนดจากหน้าเว็บ 9000/documents
    public Collection<Document> Documents() {                                    // ดึงข้อมูลจากใน Entity <Document> โดยทำเป็น collection 
        return documentRepository.findAll().stream().collect(Collectors.toList());  // ส่งค่าทั้งหมดใน document return ไปแสดงที่หน้า 9000/document โดยส่งทั้งหมดออกไปเป็น list
    }

    @PostMapping("/document/{bookName}/{writterName}/{booktypeID}/{languageID}/{numberID}")
    public Document newDocument( Document newDocument,
    @PathVariable String bookName,
    @PathVariable String writterName,
    @PathVariable long booktypeID,
    @PathVariable long languageID,
    @PathVariable long numberID ) {
        
        System.out.println(">>>>>>>>>>>>>>>>>" + bookName);
        System.out.println(">>>>>>>>>>>>>>>>>" + writterName);

        BookType booktype= booktypeRepository.findById(booktypeID);
        Language language = languageRepository.findById(languageID);
        Number number =  numberRepository.findById(numberID);

        
        newDocument.setBookType(booktype);
        newDocument.setLanguage(language);
        newDocument.setNumber(number);
                                       
        return documentRepository.save(newDocument);
    }
}

