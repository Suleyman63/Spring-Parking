package com.example.demo.repository;

import com.example.demo.model.Park;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkRepository extends JpaRepository<Park, Long> {


}
