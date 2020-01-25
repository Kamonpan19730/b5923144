package com.example.demo.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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
@Table(name="Video" , uniqueConstraints = @UniqueConstraint(columnNames = {"VIDEO_NAME" , "VIDEO_CODE"}))
public class Video {

    @Id
    @SequenceGenerator(name="video_seq",sequenceName="video_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="video_seq")  
    @Column(name = "VIDEO_ID", unique = true, nullable = true)
    @NonNull
    private Long videoid;

    @Column(name = "VIDEO_NAME")
    @NotNull(message = "videoName must not be null")
    @Size(min = 2, max = 20 , message = "VideoName Must Be Beetween 2-20 Characters")
    private String videoName;

    @Column(name = "VIDEO_CODE")
    @NotNull(message = "VideoCode Must Not Be Null")
    @Pattern(regexp = "\\d{5}" , message = "VideoCode Must Have 5 digits")
    private String videoCode;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Type.class)
    @JoinColumn(name = "TYPE_ID", insertable = true)
    @NotNull
    private Type type;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Category.class)
    @JoinColumn(name = "CATEGORY_ID", insertable = true)
    @NotNull
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Librarian.class)
    @JoinColumn(name = "LIBRARIAN_ID", insertable = true)
    @NotNull
    private Librarian librarian;
}