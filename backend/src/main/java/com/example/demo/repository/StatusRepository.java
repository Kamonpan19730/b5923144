package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

import com.example.demo.entity.Status;

@RepositoryRestResource
public interface StatusRepository extends JpaRepository<Status, Long>{
    Optional<Status> findById(Long id);
}