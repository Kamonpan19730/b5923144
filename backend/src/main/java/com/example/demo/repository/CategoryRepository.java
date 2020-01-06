package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Category;;

@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, Long>{
    Category findById(long categoryid);
}