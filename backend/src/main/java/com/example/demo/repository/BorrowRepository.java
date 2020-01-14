package com.example.demo.repository;

import com.example.demo.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface BorrowRepository extends JpaRepository<Borrow, Long>{
    public  Borrow findById(long borrowid);
}