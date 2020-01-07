package com.example.demo.entity;
import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Member")
public class Member {

    @Id
    @SequenceGenerator(name="Member_seq",sequenceName="Member_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Member_seq")
    @Column(name = "Member_ID")

    private @NonNull Long memberid;
    private @NonNull String name;
    private @NonNull String idcard;  //Not interger bcz not space for 13 number

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Province.class)
    @JoinColumn(name = "Province_ID", insertable = true)
    //@JoinColumn(name = "Province_ID")
    private Province province;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Prefix.class)
    @JoinColumn(name = "Prefix_ID", insertable = true)
  //  @JoinColumn(name = "Prefix_ID")
    private Prefix prefix;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Memtype.class)
    @JoinColumn(name = "Memtype_ID", insertable = true)
    //@JoinColumn(name = "Memtype_ID")
    private Memtype memtype;
}
