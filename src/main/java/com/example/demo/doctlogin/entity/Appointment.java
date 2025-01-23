package com.example.demo.doctlogin.entity;

import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String age ;
	private String symtomps;
	
	private String number;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSymtomps() {
		return symtomps;
	}
	public void setSymtomps(String symtomps) {
		this.symtomps = symtomps;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Appointment(long id, String name, String age, String symtomps, String number) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.symtomps = symtomps;
		this.number = number;
	}
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Appointment [id=" + id + ", name=" + name + ", age=" + age + ", symtomps=" + symtomps + ", number="
				+ number + "]";
	}
	
	
	
	

}
