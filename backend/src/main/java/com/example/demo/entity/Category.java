package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

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
    @NonNull
    private Long categoryid;

    @NotNull(message = "Category Must Not Be Null")
    private String category;

}