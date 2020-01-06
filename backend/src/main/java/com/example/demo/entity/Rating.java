package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

@Entity  
@Data  
@NoArgsConstructor  
@Table

public class Rating {

    @Id   
    @GeneratedValue
    @Column(unique = true)
    private Long id;
    
    @NonNull
    private String rating;
	
}