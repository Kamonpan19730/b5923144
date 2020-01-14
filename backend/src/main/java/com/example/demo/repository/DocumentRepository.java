package com.example.demo.repository;
import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface DocumentRepository extends JpaRepository<Document, Long> {
    public Document findById(long documentid);
}    //JPA เป็นตัว map class ให้เป็น Database