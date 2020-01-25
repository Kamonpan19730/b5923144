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

@Entity
@Data // เข้าใจ getter setter อัตโนมัติ เราจึงไม่สร้างก็ได้
@Table(name = "language")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Language {
    @Id
    @SequenceGenerator(name = "language_seq", sequenceName = "language_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "language_seq")
    @Column(name = "languageId", unique = true)

    private @NotNull Long id;
    private @NotNull String languageName;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getLanguageName() {
        return this.languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

}