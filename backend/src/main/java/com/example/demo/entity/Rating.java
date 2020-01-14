package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

@Entity  
@Data  
@NoArgsConstructor  
@Table

public class Rating {

    @Id   
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="RATING_SEQ")  
    private Long id;
    
    @NonNull
    private String rating;
	
}