package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Member;

@RepositoryRestResource
public interface MemberRepository extends JpaRepository<Member, Long>{
    Member findById(long memberid);
}