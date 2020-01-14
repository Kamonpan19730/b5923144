package com.example.demo.repository;
import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface BookTypeRepository extends JpaRepository<BookType, Long> {
	public BookType findById(long id);
}