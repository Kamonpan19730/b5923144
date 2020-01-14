package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.*;


@Entity                 
@Data                   //เข้าใจ getter setter อัตโนมัติ เราจึงไม่สร้างก็ได้ 
@Table(name="bookstatus")   
@NoArgsConstructor
@ToString
public class BookStatus {  
    @Id                                                                      
    @SequenceGenerator(name="bookstatus_seq",sequenceName="bookstatus_seq")          
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bookstatus_seq")
    @Column(name="bookstatusId",unique = true, nullable = false)          

    private @NonNull Long id;                                        
    private @NonNull String bookStatusName;
	

}