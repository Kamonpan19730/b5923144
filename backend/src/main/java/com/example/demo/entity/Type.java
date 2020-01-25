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

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Type")
public class Type {

    @Id
    @SequenceGenerator(name="type_seq",sequenceName="type_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="type_seq")  
    @Column(name = "TYPE_ID", unique = true, nullable = true)
    @NonNull
    private Long typeid;

    @NotNull(message = "Type Must Not Be Null")
    private String type;

}