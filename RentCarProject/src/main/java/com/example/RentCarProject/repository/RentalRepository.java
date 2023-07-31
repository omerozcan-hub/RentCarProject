package com.example.RentCarProject.repository;

import com.example.RentCarProject.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
}
