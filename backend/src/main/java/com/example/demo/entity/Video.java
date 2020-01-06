package com.example.demo.entity;

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


@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Video")
public class Video {

    @Id
    @SequenceGenerator(name="video_seq",sequenceName="video_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="video_seq")  
    @Column(name = "VIDEO_ID", unique = true, nullable = true)
    private @NonNull Long videoid;
    private @NonNull String videoName;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Type.class)
    @JoinColumn(name = "TYPE_ID", insertable = true)
    private @NonNull Type type;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Category.class)
    @JoinColumn(name = "CATEGORY_ID", insertable = true)
    private @NonNull Category category;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Librarian.class)
    @JoinColumn(name = "LIBRARIAN_ID", insertable = true)
    private @NonNull Librarian librarian;
}