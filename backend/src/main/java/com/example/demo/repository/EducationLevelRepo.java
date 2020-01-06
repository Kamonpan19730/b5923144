package com.example.demo.repository;

import com.example.demo.entity.EducationLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface EducationLevelRepo extends JpaRepository<EducationLevel, Long>{

}