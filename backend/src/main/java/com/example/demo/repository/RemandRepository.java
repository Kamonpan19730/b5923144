package com.example.demo.repository;

import com.example.demo.entity.Remand;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface RemandRepository extends JpaRepository<Remand, Long> {} 
//JPA เป็นตัว map class ให้เป็น Database
//ทุก method ใน interface จะไม่มี Body เพราะมันเป็นคลาสที่ไม่สมบูรณ์ ตัวที่สั่งให้ทำงานคือ method ใน Class controller 
//Repo จะทำงานได้ ก็ต่อเมื่อมันไปร่วมกับคลาสอื่น ด้วยการ extends 