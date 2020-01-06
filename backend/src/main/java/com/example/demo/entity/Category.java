package com.example.demo.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Category")
public class Category {

    @Id
    @SequenceGenerator(name="category_seq",sequenceName="category_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="gategory_seq")  
    @Column(name = "CATEGORY_ID", unique = true, nullable = true)
    private @NonNull Long categoryid;
    private @NonNull String category;

}