package com.example.RentCarProject.repository;

import com.example.RentCarProject.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
