package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.doctlogin.entity.Appointment;
import com.example.demo.entity.Patient;
import com.example.demo.repository.PatientRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class PatientController {
	@Autowired
	PatientRepository Patientrepository;
	
	@PostMapping("/patients")
	public Patient createPatient(@RequestBody Patient patient)
	{
		return Patientrepository.save(patient);	
	}

	@GetMapping("/patients")
	public List<Patient> getAllPatient(){
		return Patientrepository.findAll();
		
	}
	
	@GetMapping("patients/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable long id) throws AttributeNotFoundException
	{
		Patient patient=Patientrepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Patient not found with id : "+id));
		return  ResponseEntity.ok(patient);
	}
	
	@DeleteMapping("/patients/{id}")
	public ResponseEntity<Map<String , Boolean>>deleteAppointment(@PathVariable long id ) throws AttributeNotFoundException
	{
		Patient patient = Patientrepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Patient not found with id"+id));
		Patientrepository.delete(patient);
		Map<String,Boolean> response=new HashMap<String,Boolean>();
		response.put("Deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/patients/{id}")
	public ResponseEntity<Patient> updatePatientById(@PathVariable long id , @RequestBody Patient patientDetails) throws AttributeNotFoundException{
		
		Patient patient = Patientrepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Patient not found with id"+id));	
	patient.setAge(patientDetails.getAge());
	patient.setName(patientDetails.getName());
	patient.setBlood(patientDetails.getBlood());
	patient.setDose(patientDetails.getDose());
	patient.setFees(patientDetails.getFees());
	patient.setPrescription(patientDetails.getPrescription());
	patient.setUrgency(patientDetails.getUrgency());

	Patient savedPatient=Patientrepository.save(patient);
	return ResponseEntity.ok(savedPatient);
	
	
	}
	

}
