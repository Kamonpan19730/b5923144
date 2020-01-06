package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Prefix;

@RepositoryRestResource
public interface PrefixRepository extends JpaRepository<Prefix, Long>{
    Prefix findById(long prefixid);
}

