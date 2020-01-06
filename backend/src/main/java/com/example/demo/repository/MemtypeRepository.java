package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Memtype;

@RepositoryRestResource
public interface MemtypeRepository extends JpaRepository<Memtype, Long>{
    Memtype findById(long memtypeid);
}