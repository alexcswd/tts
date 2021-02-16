package com.samples.tts.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	@OneToMany(mappedBy = "department")
	@JsonBackReference
	private List<User> employees;
	
	public Department() { }

	public Department(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getEmployees() {
		return employees;
	}

	public void setEmployees(List<User> employees) {
		this.employees = employees;
	}
	
	public void addEmployee(User employee) {
		if (employee != null) {
			if (employees == null) {
				employees = new ArrayList<>();
			}
			employee.setDepartment(this);
			employees.add(employee);
		}
	}
}
