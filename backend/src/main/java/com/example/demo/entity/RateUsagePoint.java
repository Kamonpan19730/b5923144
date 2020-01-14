package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.*;

@Entity
@Data  
@NoArgsConstructor  
@Table
public class RateUsagePoint {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="RATEUP_SEQ") 
    private Long id;
 
    @ManyToOne
    @NonNull
    private Status status;

    @ManyToOne
    @NonNull
    private EducationLevel edlevel;

    @NonNull
    private Date date;
      
    @NonNull 
    private String email; 
    
    @NonNull
    private String suggestion;

    @ManyToOne
    @NonNull
    private Rating rating;


}