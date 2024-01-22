package com.example.demo.H2.repo;

import com.example.demo.H2.entites.ApiDatah;
import org.springframework.data.jpa.repository.JpaRepository;

public interface H2Repository extends JpaRepository<ApiDatah, Long> {
}
