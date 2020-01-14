package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor
@Data
@Table
public class Status{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STATUS_SEQ")  
    private Long id;

    @NonNull
    private String status;

}