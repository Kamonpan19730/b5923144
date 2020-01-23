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
@Table(name="Memtype")
public class Memtype {  
      
  @Id
  @SequenceGenerator(name="memtype_seq",sequenceName="memtype_seq")               
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="memtype_seq")  
  @Column(unique = true)
  //@Column(name = "memtype_ID", unique = true, nullable = true)
  private @NonNull Long memtypeid;
  private @NonNull String memtype;
public static Object builder() {
	return null;
}

}