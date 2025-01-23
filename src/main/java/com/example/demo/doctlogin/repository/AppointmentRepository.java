package com.example.demo.doctlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.doctlogin.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
