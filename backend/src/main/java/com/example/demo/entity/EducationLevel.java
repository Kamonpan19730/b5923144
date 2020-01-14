package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

@Entity
@NoArgsConstructor
@Data
@Table
public class EducationLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="EDUCATION_SEQ")  
    private Long id;

    @NonNull
    private String edlevel;
}