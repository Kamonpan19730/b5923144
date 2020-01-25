package com.example.demo.entity;

import java.util.Date;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
@Table(name = "Borrow")
public class Borrow {

    @Id
    @GeneratedValue
    @Column(unique = true)
    private Long borrowId;
    @NotNull(message = "number must be not null")
    private Long numbers;
    @NotNull(message = "borrow date must be not null")
    private Date borrowDate;
    @Size(max = 25, message = "description must be max 25 characters")
    private String Descripton;
    @Pattern(regexp = "\\d{10}", message = "tell must be digit and 10 characters")
    private String tell;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member.class)
    @JoinColumn(name = "Member_ID", insertable = true, nullable = false)
    // @JoinColumn(name = "Member_ID")
    @NotNull(message = "member must be not null")
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = BookType.class)
    @JoinColumn(name = "booktype", insertable = true)
    // @JoinColumn(name = "booktype")
    @NotNull(message = "book type must be not null")
    private BookType bookType;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Document.class)
    @JoinColumn(name = "documentId", insertable = true)
    // @JoinColumn(name = "booktype")
    @NotNull(message = "document must be not null")
    private Document document;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Memtype.class)
    @JoinColumn(name = "Memtype", insertable = true)
    // @JoinColumn(name = "Memtype")
    @NotNull(message = "member type must be not null")
    private Memtype memtype;

}