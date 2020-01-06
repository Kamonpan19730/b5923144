package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Librarian;

@RepositoryRestResource
public interface LibrarianRepository extends JpaRepository<Librarian, Long> {
    Librarian findById(long librarianid);
}