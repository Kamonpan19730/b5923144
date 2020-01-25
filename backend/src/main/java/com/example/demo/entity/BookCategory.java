package com.example.demo.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data // เข้าใจ getter setter อัตโนมัติ เราจึงไม่สร้างก็ได้
@Table(name = "bookcategory")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookCategory {
    @Id
    @SequenceGenerator(name = "bookcategory_seq", sequenceName = "bookcategory_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookcategory_seq")
    @Column(name = "bookcategoryId", unique = true)

    private @NotNull Long id;
    private @NotNull String bookCategoryName;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getBookCategoryName() {
        return this.bookCategoryName;
    }

    public void setBookCategoryName(String bookCategoryName) {
        this.bookCategoryName = bookCategoryName;
    }

}