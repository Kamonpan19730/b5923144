package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;;
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

@Table(name = "Member")
public class Member {

  @Id
  @SequenceGenerator(name = "Member_seq", sequenceName = "Member_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Member_seq")
  @Column(name = "Member_ID")

  private Long memberid;

  @NotNull(message = "Name Must Not Be Null")
  @Size(min = 4, max = 50 , message = "VideoName Must Be Beetween 4-50 Characters")
  private String name;

  @NotNull(message = "idcard Must Not Be Null")
  @Pattern(regexp = "\\d{13}" , message = "idcard Must Have 13 digits")
  private String idcard; 

  @ManyToOne(fetch = FetchType.EAGER, targetEntity = Province.class)
  @JoinColumn(name = "Province_ID", insertable = true)
  @NotNull(message = "province Must Not Be Null")
  private Province province;

  @ManyToOne(fetch = FetchType.EAGER, targetEntity = Prefix.class)
  @JoinColumn(name = "Prefix_ID", insertable = true)

  @NotNull(message = "prefix Must Not Be Null")
  private Prefix prefix;

  @ManyToOne(fetch = FetchType.EAGER, targetEntity = Memtype.class)
  @JoinColumn(name = "Memtype_ID", insertable = true)
  @NotNull(message = "memtype Must Not Be Null")
  private Memtype memtype;

}


