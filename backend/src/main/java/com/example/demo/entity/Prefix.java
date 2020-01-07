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
@Table(name="Prefix")
public class Prefix {  
      
  @Id
  @SequenceGenerator(name="prefix_seq",sequenceName="prefix_seq")               
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="prefix_seq")  
  @Column(name = "prefix_ID", unique = true, nullable = true)
  private @NonNull Long prefixid;
  private @NonNull String prefix;

}