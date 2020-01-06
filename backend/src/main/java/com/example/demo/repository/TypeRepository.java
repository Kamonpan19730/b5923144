package com.example.demo.repository;

import  org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Type;;

@RepositoryRestResource
public interface TypeRepository extends JpaRepository<Type, Long> {
    Type findById(long typeid);
}