package com.example.springbootvue.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Province")
public class Province {

    @Id
    @SequenceGenerator(name="Province_seq",sequenceName="Province_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Province_seq")
    @Column(name = "Province_ID")

    private @NonNull Long provinceid;
    private @NonNull String pro;
}
