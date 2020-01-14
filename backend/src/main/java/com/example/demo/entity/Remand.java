//Entity คือ การ map จาก java class ไปเป็น Database 
//โดยไม่ต้องมานั่งเขียนตารางเอง ให้ framwork ทำงานแทน 
//และเวลาดึงมาใช้ก็ไม่ต้องกลัวว่าจะมาแบบ แถว หรือ คอลัม เพราะ framwork จะส่งมาเป็น obj ให้เอง
package com.example.demo.entity;      //กำลังบอกว่า package นี้ เป็นของ Entity
import lombok.*;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import java.util.Date;

@Entity                 
@Data                   
@Table                  
//@Getter                 //เรียกใช้ Getter เอาไว้จำกัดการเข้าถึง เพื่อ get ค่าให้กับแต่ละ attribute
//  @Setter                 //เรียกใช้ Setter เอาไว้จำกัดการเข้าถึง เพื่อ set ค่าให้กับแต่ละ attribute
@NoArgsConstructor      
public class Remand {             
    @Id                             //คือ annotation ที่ไว้สร้าง Primary Key โดยใช้งานร่วมกับ SequenceGenerator และ GeneratedValue
    //กำหนดว่า file นี้เป็น PK          
    @SequenceGenerator(name="remand_seq",sequenceName="remand_seq") //ในกรณีนี้ id ของเราจำเป็นต้อง run ขึ้นมาเอง   
                                    //Sequence ใช้ในการ Generate Value แบบ random หรือง่ายๆคือ เกี่ยวกับการลำดับ
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="remand_seq") 
                                    //เป็นการนำ remand_seq มาใช้ ในการ Generate Value หรือสร้าง id primary key ที่ไม่ซ้ำกันออกมา
                                    //ส่วนมาก SequenceGenerator และ GeneratedValue จะมาคู่กัน
                                    //แต่ถ้ากรณี OneToOne จะมีแค่ GeneratedValue
    @Column(name="remandId",unique = true, nullable = false)       
                                    //Column คือ ตอนไปสร้างใน DB ให้สร้างชื่อ Column ว่า remandId , Column นี้ ลบไม่ได้นะ , Column นี้ ว่างไม่ได้นะ           
                                    //ชื่อคอลัม remandId , ไม่ซ้ำ , ไม่ว่าง 
                                    //unique = SQL , 
                                    //nullable = ถ้ากรณีไม่ใส่ ชื่อคอลัม จะได้คอลัมชื่อ null
    private Long id; 
    //id ของ entity นี้   

    /*@Column(name="examresultName")  
                                    //Column คือ ตอนไปสร้างใน DB ให้สร้างชื่อ Column ว่า examresultName
    private @NonNull String examresultName; */
                                    
     @Column(name = "Remanddate")
     private Date remanddate;

    @ManyToOne
    private @NonNull Status statusName;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Borrow.class)     //เชื่อมความสัมพันธุ์แบบ ManyToOne กับ Entity เป้าหมาย คือ Borrow   //เป็น FK ที่ชีี้ไปที่ PK ของ Borrow ไม่มั่นใจ
    @JoinColumn(name = "borrowID", insertable = true)                     
    private Borrow borrow; 

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member.class)                         
    @JoinColumn(name = "memberID", insertable = true)    //ไป Join กับ Column ที่ชื่อ memberID โดยให้ insertable(เพิ่มลงตารางหรือไม่)  = true
    private @NonNull Member member;
   


    @ManyToOne(fetch = FetchType.EAGER, targetEntity = BookType.class)   
    @JoinColumn(name = "booktypeID", insertable = true)
    private @NonNull BookType bookType;   
    
    
    //ในหน้านี้จะเป็นการรับมาจาก UI ก่อน แล้วการ JoinColumn คือ การดึงไอดีจาก Entity ดังกล่าวมา
}