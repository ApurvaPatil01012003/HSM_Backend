package com.example.demo.doctlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.doctlogin.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {

}
