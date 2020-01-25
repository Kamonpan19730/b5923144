package com.example.demo.repository;

import com.example.demo.entity.*;
import com.example.demo.entity.BookCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {
	public BookCategory findById(long id);
}