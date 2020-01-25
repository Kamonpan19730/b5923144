package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.*;

@Entity
@Data // เข้าใจ getter setter อัตโนมัติ เราจึงไม่สร้างก็ได้
@Table(name = "booktype")
@NoArgsConstructor
@ToString
@Builder
@AllArgsConstructor
public class BookType {
    @Id
    @SequenceGenerator(name = "booktype_seq", sequenceName = "booktype_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booktype_seq")
    @Column(name = "booktypeId", unique = true, nullable = false)

    private Long id;
    @NotNull
    private String bookTypeName;

}