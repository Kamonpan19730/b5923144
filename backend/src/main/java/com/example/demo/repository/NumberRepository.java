package com.example.demo.repository;

import com.example.demo.entity.*;
import com.example.demo.entity.Number;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface NumberRepository extends JpaRepository<Number, Long> {
	public Number findById(long id);
}