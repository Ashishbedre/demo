package com.example.demo.MySQL.repo;


import com.example.demo.MySQL.entities.ApiData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MySQLRepository extends JpaRepository<ApiData, Long> {
}