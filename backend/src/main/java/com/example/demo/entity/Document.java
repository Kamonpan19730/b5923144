package com.example.demo.entity; //กำลังบอกว่า package นี้ เป็นของ Entity

import lombok.*;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Entity // ทำให้ class Document เป็น Entity
@Data // กำหนดให้เก็บข้อมูล และช่วยในการสร้าง get , set
@Table // บอกว่า Entity นี้ ทำหน้าที่ เก็บข้อมูล
@Getter // เรียกใช้ Getter เอาไว้จำกัดการเข้าถึง เพื่อ get ค่าให้กับแต่ละ attribute
@Setter // เรียกใช้ Setter เอาไว้จำกัดการเข้าถึง เพื่อ set ค่าให้กับแต่ละ attribute
@NoArgsConstructor //
public class Document { // บอกตำแหน่งปัจจุบัน

    @Id // คือ annotation ที่ไว้สร้าง Primary Key
    @SequenceGenerator(name = "document_seq", sequenceName = "document_seq") //
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_seq") //
    @Column(name = "documentId", unique = true) // ชื่อคอลัม documentId , ไม่ซ้ำ , ไม่ว่าง
    private @NotNull Long id;

    @Size(min = 2, max = 30)
    @Pattern(regexp =  "^[A-Za-zก-์\\s]+$")
    private @NotNull String writterName;

    @Size(min = 2, max = 30)
    @Pattern(regexp =  "^[A-Za-zก-์\\s]+$")
    private @NotNull String bookName;

    @Min(1) @Max(20)
    private @NotNull Integer amount;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // จำกัดการเข้าถึง documentId
    public String getBookName() {
        return this.bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getWritterName() {
        return this.writterName;
    }

    public void setWritterName(String writterName) {
        this.writterName = writterName;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = BookType.class)
    @JoinColumn(name = "booktypeID", insertable = true)
    private BookType bookType;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Language.class)
    @JoinColumn(name = "languageID", insertable = true)
    private Language language;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = BookCategory.class)
    @JoinColumn(name = "bookcategoryID", insertable = true)
    private BookCategory bookCategory;

    public BookType getBookType() {
        return this.bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public Language getLanguage() {
        return this.language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public BookCategory getBookCategory() {
        return this.bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }

}