package com.example.demo.doclogin.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.doctlogin.entity.Medicine;
import com.example.demo.doctlogin.repository.MedicineRepository;

@RestController
@RequestMapping("/api/v3")
@CrossOrigin
public class MedicineController {
	@Autowired
	MedicineRepository medicineRepository;
	@PostMapping("/insert")
	public Medicine createMedicine(@RequestBody Medicine medicine)
	{
		return medicineRepository.save(medicine);
		
	}
	
	
	@GetMapping("/medicines")
	public List<Medicine> getAllMedicine(){
		return medicineRepository.findAll();
		
	}

}
